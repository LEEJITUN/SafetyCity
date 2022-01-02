// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Area Chart Example
let myAreachart = document.getElementById("myAreaChart");
let currtime = document.querySelector('.curr-time');

let currentTime = new Date();


currtime.innerHTML = '현재 시각은 ' +
    currentTime.getHours() + ' 시 ' +
    currentTime.getMinutes() + ' 분 ' +
    currentTime.getSeconds() + ' 초 입니다.';

function random_rgba() {
    var o = Math.round, r = Math.random, s = 100
    return 'rgba(' + o(r()*s) + ',' + o(r()*s) + ',' + o(r()*s) + ',' + r().toFixed(1) + ')';
}

function getTimeforDb(){
    let currHour = currentTime.getHours();

    if(currHour < 3){
        return "00:00~02:59";
    }else if(currHour < 6){
        return "03:00~05:59";
    }else if(currHour < 9){
        return "06:00~08:59";
    }else if(currHour < 12){
        return "09:00~11:59";
    }else if(currHour < 15){
        return "12:00~14:59";
    }else if(currHour < 18){
        return "15:00~17:59";
    }else if(currHour < 21){
        return "18:00~20:59";
    }else if(currHour < 24){
        return "21:00~23:59";
    }
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

let myBarChart = document.getElementById("myBarChart");
let labels = []
let datas = []

fetch("/api/crime/time/" + getTimeforDb())
    .then((res) => res.json())
    .then((content) => {
        content.map((data) => {
            labels.push(data.name);
            datas.push(data.count);
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
                            label: "위험지수",
                            backgroundColor: "rgba(200, 50, 50, 1)",
                            borderColor: "rgba(200, 50, 50, 1)",
                            data: datas,
                        },
                    ],
                },
            });
        }
    });

let currtimetext = document.getElementById('curr-time');

currtimetext.innerHTML = '현재 시간 ' + currentTime.getHours() + ' : '
    + currentTime.getMinutes() + ' 의 위험 범죄는!!'




