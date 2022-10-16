import { renderEditClientForm } from "./clientForm.js";

(async () => {
    const urlParams = new URLSearchParams(window.location.search)
    const clientId = urlParams.get("id");

    await renderEditClientForm("clientFormContainer", clientId)
})();