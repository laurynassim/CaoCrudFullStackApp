import {
    getAllClients,
    deleteClientById,
} from "../js/requests.js";

let tableParentDivId = undefined;

export const renderClientTable = async (targetId) => {
  tableParentDivId = targetId;
  const carclients = await getAllClients();
  if (document.getElementById("clientTable")) {
    document.getElementById("clientTable").remove();
  }
  const table = document.createElement("table");
  table.id = "clientTable";
  table.className = "table table-striped";

  renderClientTableHeaders(table);
  const tbody = document.createElement("tbody");
  carclients.forEach((client) => {
    renderClientTableRow(tbody, client);
  });

  table.appendChild(tbody);
  document.getElementById(tableParentDivId).appendChild(table);
};

const renderTableCell = (innerText, className) => {
  const td = document.createElement("td");
  if (innerText) {
    td.innerText = innerText;
  }
  if (className) {
    td.className = className;
  }
  return td;
};

const renderTableHeader = (innerText) => {
  const th = document.createElement("th");
  th.innerText = innerText;
  return th;
};

const renderActionButtons = (actionsCell, id) => {
  const editButton = document.createElement("button");
  editButton.innerText = "Edit";
  editButton.className = "btn btn-warning editButton";
  editButton.addEventListener("click", () => {
    handleEdit2(id);
  });

 

  const deleteButton = document.createElement("button");
  deleteButton.innerText = "Delete";
  deleteButton.className = "btn btn-danger deleteButton";
  deleteButton.addEventListener("click", () => {
    handleDelete(id);
  });

  actionsCell.append(editButton, deleteButton);
};

const handleEdit2 = async (id) => {
  window.location.replace(`../html/client-edit.html?id=${id}`);
};



const handleDelete = async (id) => {
  await deleteClientById(id);
  await renderClientTable(tableParentDivId);
};

const renderClientTableRow = (tbody, client) => {
  const tr = document.createElement("tr");
  tr.id = `client-${client.id}`;
  const nameCell = renderTableCell(client.name, "nameCell");
  const surnameCell = renderTableCell(client.surname, "surnameCell");
  const emailCell = renderTableCell(client.email, "emailCell");
  const birthDateCell = renderTableCell(client.dateOfBirth, "dateOfBirthCell");
  const actionsCell = renderTableCell(undefined, "actionsCell");
  renderActionButtons(actionsCell, client.id);

  tr.append(nameCell, surnameCell, emailCell, birthDateCell, actionsCell);

  tbody.appendChild(tr);
};

const renderClientTableHeaders = (table) => {
  const tr = document.createElement("tr");
  const thead = document.createElement("thead");
  tr.appendChild(thead);
  const nameTh = renderTableHeader("Client name");
  const surnameTh = renderTableHeader("surname");
  const emailTh = renderTableHeader("email");
  const birthDateTh = renderTableHeader("date of birth");
  const actionsTh = renderTableHeader("Actions");
  

  thead.append(nameTh, surnameTh, emailTh, birthDateTh,  actionsTh);
  table.appendChild(thead);
};
