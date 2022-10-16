import{
    getClientById,
    saveClient,
    updateClient,
} from "../js/requests.js"

let formParentDivId = undefined;

const handleClientFormSubmit = async (form) => {
  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    await submitClient(
      form.name.value,
      form.surname.value,
      form.email.value,
      form.dateOfBirth.value,
    );
    window.location.replace("../html/clientList.html");
  });
};

const handleEditClientFormSubmit = async (form, clientId) => {
  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    await editClient(
      form.name.value,
      form.surname.value,
      form.email.value,
      form.dateOfBirth.value,
      clientId
    );
    window.location.replace("../html/clientList.html");
  });
};

const editClient = async (name, surname, email, dateOfBirth,  clientId) => {
  const client = { name, surname, email, dateOfBirth };
  await updateClient(client, clientId);
};

const submitClient = async (name, surname, email, dateOfBirth) => {
  const client = { name, surname, email, dateOfBirth };
  await saveClient(client);
};

const renderInputField = (form, name, id, defaultValue) => {
  const div = document.createElement("div");
  div.className = "mb-3";

  const label = document.createElement("label");
  label.for = id;
  label.innerText = name;

  const input = document.createElement("input");
  input.type = "text";
  input.name = id;
  input.id = id;
  input.className = "form-control";

  if (defaultValue) {
    input.value = defaultValue;
  }

  div.append(label, input);
  form.appendChild(div);
};

const renderSaveButton = (form) => {
  const div = document.createElement("div");
  div.className = "actions";

  const button = document.createElement("button");
  button.type = "submit";
  button.className = "btn btn-primary";
  button.innerText = "Save";

  div.appendChild(button);
  form.appendChild(div);

  
};

const renderCancelButton = (form) => {
  const div = document.createElement("div");
  div.className = "actions";

  const button = document.createElement("button");
  button.type = "button";
  button.className = "btn btn-primary";
  button.innerText = "cancel";

  div.appendChild(button);
  form.appendChild(div);

  button.addEventListener("click", () =>
    window.location.replace("../html/clientList.html")
  );

};



const renderEditButtons = (form) => {
  const div = document.createElement("div");
  div.className = "actions";

  const saveButton = document.createElement("button");
  saveButton.type = "submit";
  saveButton.className = "btn btn-success";
  saveButton.innerText = "Save";

  const cancelButton = document.createElement("button");
  cancelButton.type = "submit";
  cancelButton.className = "btn btn-danger";
  cancelButton.innerText = "Cancel";
  cancelButton.addEventListener("click", () =>
    window.location.replace("../html/clientList.html")
  );

  div.append(saveButton, cancelButton);
  form.appendChild(div);
};

export const renderSaveClientForm = async (targetId) => {
  formParentDivId = targetId;
  const form = document.createElement("form");
  form.id = "clientForm";

  renderInputField(form, "Client's name", "name");
  renderInputField(form, "surname", "surname");
  renderInputField(form, "email", "email");
  renderInputField(form, "dateOfBirth", "dateOfBirth");
  renderSaveButton(form),
  renderCancelButton(form);

  await handleClientFormSubmit(form);
  document.getElementById(formParentDivId).appendChild(form);
  console.log(form.elements);
};

export const renderEditClientForm = async (targetId, clientId) => {
  formParentDivId = targetId;
  const form = document.createElement("form");
  form.id = "clientForm";

  const client = await getClientById(clientId);

  renderInputField(form, "Company name", "name", client.name);
  renderInputField(form, "surname", "surname", client.surname);
  renderInputField(form, "email", "email", client.email);
  renderInputField(form, "dateOfBirth", "dateOfBirth", client.dateOfBirth);
  renderEditButtons(form);

  await handleEditClientFormSubmit(form, clientId);
  document.getElementById(formParentDivId).appendChild(form);
};
