// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = "#292b2c";

// Bar Chart Example
let myBarChart = document.getElementById("myBarChart");
let lamplabels = []
let lampdatas = []



fetch("/api/lampcnt")
    .then((res) => res.json())
    .then((datas) => {
        datas.map((data) => {
            let names = data.name.split(' ');
            let name = names[names.length - 1]
          lamplabels.push(name)
          lampdatas.push(data.cnt)
        })
    })
    .then(() => {
        if(myBarChart){
            new Chart(myBarChart, {
                type: "bar",
                data: {
                    labels: lamplabels,
                    datasets: [
                        {
                            label: "가로등",
                            backgroundColor: "rgba(2,255,212,1)",
                            borderColor: "rgba(2,255,212,1)",
                            data: lampdatas,
                        },
                    ],
                },
            });
        }
        }
    )




