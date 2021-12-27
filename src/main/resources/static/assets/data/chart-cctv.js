// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = "#292b2c";

// Bar Chart Example
let myBarChart = document.getElementById("myBarChart");
let cctvlabels = []
let cctvdatas = []



fetch("/api/cctvcnt")
    .then((res) => res.json())
    .then((datas) => {
        datas.map((data) => {
          cctvlabels.push(data.name)
          cctvdatas.push(data.cnt)
        })
    })
    .then(() => {
        if(myBarChart){
            new Chart(myBarChart, {
                type: "bar",
                data: {
                    labels: cctvlabels,
                    datasets: [
                        {
                            label: "cctv",
                            backgroundColor: "rgba(2,117,216,1)",
                            borderColor: "rgba(2,117,216,1)",
                            data: cctvdatas,
                        },
                    ],
                },
            });
        }
        }
    )




