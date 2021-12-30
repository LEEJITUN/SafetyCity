// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Area Chart Example
let myAreachart = document.getElementById("myAreaChart");
let currtime = document.querySelector('.curr-time');

let currentTime = new Date(Date.now()).fo
currtime.innerHTML = currentTime.toString();

function random_rgba() {
    var o = Math.round, r = Math.random, s = 255;
    return 'rgba(' + o(r()*s) + ',' + o(r()*s) + ',' + o(r()*s) + ',' + r().toFixed(1) + ')';
}

fetch("/api/crime")
    .then((res) => res.json())
    .then((datas) => {
        let dataset = []

        datas.map((data) => {
            let randColor = random_rgba();
            let obj = {
                label: data[0].name,
                headings: data[0].name,
                fill: false,
                lineTension: 0.3,
                borderColor: randColor,
                pointRadius: 5,
                pointBackgroundColor: randColor,
                pointBorderColor: "rgba(255,255,255,0.8)",
                pointHoverRadius: 5,
                pointHoverBackgroundColor: randColor,
                pointHitRadius: 50,
                pointBorderWidth: 2,
                data: []
            };
            for ( let i = 0; i < data.length; i++ ) {
                obj.data.push(data[i].count);
            }
            dataset.push(obj);
      })
        new Chart(myAreachart, {
            type: 'line',
            data: {
                labels: ["00:00~02:59", "03:00~05:59", "06:00~08:59", "09:00~11:59", "12:00~14:59", "15:00~17:59", "18:00~20:59", "21:00~23:59"],
                datasets: dataset,
            },
        });
    });



