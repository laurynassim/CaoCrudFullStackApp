import {renderClientTable} from "../js/clientTable.js"


const handleAddNewClient = () => {
    document.getElementById("addNewClient").addEventListener("click", () => {
      window.location.replace("../html/client-add.html");
    });
  };
  
  (async () => {
    handleAddNewClient();
    await renderClientTable("clientContainer");
  })();
  
  