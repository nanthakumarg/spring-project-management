var chartJson = JSON.parse(decodeHtml(chartData));

var arrayLength = chartJson.length;

var numericData = [];
var labelData = [];

for(var i = 0; i < arrayLength; i++) {
    numericData[i] = chartJson[i].value;
    labelData[i] = chartJson[i].label;
}

var myPieChart = new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
     data: {
        labels: labelData,
        datasets: [{
            label: 'Project Status',
            backgroundColor: ['#B83227','#2475B0','#019031','#F3B431','#2C3335', '#E74292', '#badc57'],
            //borderColor: ['#B83227','#2475B0','#019031','#F3B431','#2C3335', '#E74292', '#badc57'],
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
        title: {
            display: true,
            text: 'Project Status'
        }
    }
});

function decodeHtml(html){
    var txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}