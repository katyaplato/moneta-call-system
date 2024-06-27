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
                    statusMessage.textContent = ""
                }, 5000)
            });
    });

    nextButton.addEventListener("click", function () {
        fetch("/api/get-actual")
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    statusMessage.textContent = "The queue is empty.";
                    setTimeout(() => {
                        statusMessage.textContent = "";
                    }, 5000);
                }
            })
            .then(data => {
                nextButton.style.display = "none";
                deleteButton.style.display = "none";
                generateButton.style.display = "none";

                ticketNumber.textContent = `Ticket Number: ${data.queueNumber}`;

                const ticketDateTime = new Date(data.dateTime);
                const formattedDate = ticketDateTime.toISOString().split('T')[0];
                const formattedTime = ticketDateTime.toTimeString().split(' ')[0].slice(0, 5);

                statusMessage.textContent = `An actual ticket was generated ${formattedDate} ${formattedTime}`;

                finishButton.style.display = "block";
            })
    });

    finishButton.addEventListener("click", function () {
        fetch("/api/finish-actual", {method: "DELETE"})
            .then(response => {
                statusMessage.textContent = "Current ticket finished.";
                setTimeout(() => {
                    statusMessage.textContent = "";
                }, 5000);

                const ticketNumberElement = document.getElementById("ticket-number");
                if (ticketNumberElement) {
                    ticketNumberElement.remove();
                }
                nextButton.style.display = "block";
                deleteButton.style.display = "block";
                generateButton.style.display = "block"

                finishButton.style.display = "none";
            })
    });
})