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
    var o = Math.round, r = Math.random, s = 200
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

fetch("/api/place")
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
                labels: ["아파트,연립다세대", "단독주택", "고속도로", "노상", "백화점", "슈퍼마켓", "편의점", "대형할인마트"
                ,"상점","숙박업소,목욕탕","유흥접객업소","사무실","공장","공사장,광산","창고","역,대합실","지하철","기타교통수단내","흥행장"
                , "유원지","학교","금융기관","의료기관","종교기관","산야","해상","부대","구금장소","공지","주차장","공중화장실","PC방","기타"],
                datasets: dataset,
            },
        });
    });

let myDougChart = document.getElementById("myDougChart");
let myDougChart2 = document.getElementById("myDougChart2");
let myDougChart3 = document.getElementById("myDougChart3");
let myDougChart4 = document.getElementById("myDougChart4");
let myDougChart5 = document.getElementById("myDougChart5");
/*let labels = []
let datas = []*/

function makeDoughnut(str,ob){
	let labels = []
	let datas = []
	
	fetch("/api/place/" + str)
    .then((res) => res.json())
    .then((content) => {
        content.map((data) => {
	
            labels.push(data.type);
            datas.push(data.count);
        })
    })
    .then(() => {
        if(ob){
            new Chart(ob, {
                type: "doughnut",
                data: {
                    labels: labels,
					  datasets: [{
					    label: 'My First Dataset',
					    data: datas,
					    backgroundColor: [
					      'rgb(255, 99, 132)',
					      'rgb(54, 162, 235)',
					      'rgb(255, 205, 86)'
					    ],
					    hoverOffset: 4
					  }]
                },
            });
        }
    });
}


makeDoughnut("살인",myDougChart)
makeDoughnut("강도",myDougChart2)
makeDoughnut("강간및강제추행",myDougChart3)
makeDoughnut("절도",myDougChart4)
makeDoughnut("폭력",myDougChart5)



