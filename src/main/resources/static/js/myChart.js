var myPieChart = new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
     data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ['#B83227','#2475B0','#019031','#F3B431','#2C3335', '#E74292', '#badc57'],
            borderColor: ['#B83227','#2475B0','#019031','#F3B431','#2C3335', '#E74292', '#badc57'],
            data: [25, 10, 5, 8, 20, 30, 45]
        }]
    },

    // Configuration options go here
    options: {}
});