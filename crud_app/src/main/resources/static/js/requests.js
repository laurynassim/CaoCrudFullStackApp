const API_BASE_URL = "http://localhost:8080";

export const getAllClients = async () => {
  const response = await fetch(`${API_BASE_URL}/client
  `);
  const clients = await response.json();
  return clients;
};

export const getClientById = async (clientId) => {
  const response = await fetch(`${API_BASE_URL}/client/${clientId}`);
  const client = await response.json();
  return client;
};

export const updateClient = async (client, id) => {
  await fetch(`${API_BASE_URL}/client/${id}`, {
    method: "PUT",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(client),
  });

  alert(`[client ${id}] successfully updated`);
};

export const deleteClientById = async (id) => {
  await fetch(`${API_BASE_URL}/client/${id}`, {
    method: "DELETE",
  });
  alert(`[Client ${id}] successfully deleted`);
};

export const saveClient= async (client) => {
  await fetch(`${API_BASE_URL}/client`, {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(client),
  });

  alert(`client successfully added`);
};
