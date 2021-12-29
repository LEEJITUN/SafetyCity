// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = "#292b2c";

// Bar Chart Example
let myBarChart = document.getElementById("myBarChart");
let labels = []
let itemdatas = []



fetch("/api/safetyhousecnt")
    .then((res) => res.json())
    .then((datas) => {
        datas.map((data) => {
          labels.push(data.name)
          itemdatas.push(data.cnt)
        })
    })
    .then(() => {
        if(myBarChart){
            new Chart(myBarChart, {
                type: "bar",
                data: {
                    labels: labels,
                    datasets: [
                        {
                            label: "여성안전지킴이집",
                            backgroundColor: "rgba(2,117,216,1)",
                            borderColor: "rgba(2,117,216,1)",
                            data: itemdatas,
                        },
                    ],
                },
            });
        }
        }
    )




