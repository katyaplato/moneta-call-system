document.addEventListener("DOMContentLoaded", function () {
    const nextButton = document.getElementById("next");
    const deleteButton = document.getElementById("delete");
    const finishButton = document.getElementById("finish");
    const statusMessage = document.getElementById("status-message");
    const ticketNumber = document.getElementById("ticket-number")
    const generateButton = document.getElementById("generate")

    finishButton.style.display = "none";

    generateButton.addEventListener("click", function () {
        fetch("/api/create", {method: "POST"})
            .then(response => response.json())
            .then(data => {
                statusMessage.textContent = `New ticket created with queue number ${data.queueNumber}.`;
                setTimeout(() => {
                    statusMessage.textContent = ""}, 5000)
            });
    });


})