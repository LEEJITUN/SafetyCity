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

/* const 변수 */
// 색상
const murder = ['rgb(164, 74, 74)' ,'rgb(203, 145, 145)','rgb(223, 192, 192)']
const robbery = ['rgb(80, 95, 165)' ,'rgb(111, 123, 183)','rgb(193, 198, 223)']
const rape = ['rgb(155, 155, 63)' ,'rgb(177, 177, 100)','rgb(220, 220, 187)']
const theft = ['rgb(143, 69, 179)' ,'rgb(188, 144, 211)','rgb(213, 190, 226)']
const violence = ['rgb(234, 154, 82)' ,'rgb(238, 197, 160)','rgb(241, 219, 201)']
const colorList = [murder,robbery,rape,theft,violence]

// 범죄이름, top,down
const crimeName = ['살인','강도','강간및강제추행','절도','폭력']
const topAndDown = ['T','D']


// 캔버스
let chartMain = []

/* 색상 설정 */
function random_rgba(str) {

	selectColorList = [];
	switch (str) {
	  case '살인':
		selectColorList = murder
	    break;
	  case '강도':
		selectColorList = robbery
	    break;
	  case '강간및강제추행':
		selectColorList = rape
	    break;
	  case '절도':
		selectColorList = theft
	    break;
	  default:
		selectColorList = violence
	}
	
	return selectColorList
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

/* 장소 그래프 생성 */
fetch("/api/place")
    .then((res) => res.json())
    .then((datas) => {
	
        let dataset = []

        datas.map((data) => {
			console.log('data',data[0].name)
            let randColor = random_rgba(data[0].name);
            console.log('randColor',randColor)
            let obj = {
                label: data[0].name,
                headings: data[0].name,
                fill: false,
                lineTension: 0.3,
                borderColor: randColor[2],
                pointRadius: 5,
                pointBackgroundColor: randColor[0],
                pointBorderColor: "rgba(255,255,255,0.8)",
                pointHoverRadius: 5,
                pointHoverBackgroundColor: randColor[0],
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




/* 장소 도넛그래프  생성 */
function makeDoughnut(code,str,ob,color){
	
	let labels = []
	let datas = []
	
	console.log('code',code)
	fetch("/api/place/" + code +'/'+ str)
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
					    backgroundColor:color,
					    hoverOffset: 4
					  }]
                },
            });
        }
    });
}


/* 차트 객체 생성 */
function createChart(){
	for(i = 0; i < 11; i++){
		str = ""
		if(i == 0){
			chartMain.push(document.getElementById("myDougChart"))	
		}else{
			str = str + (i+1)
			chartMain.push(document.getElementById("myDougChart"+str))	
		}
	}
}


//차트 만들기
function makeChart(){
	for(i = 0; i < chartMain.length ; i++){
		
		if(i < 6){
			makeDoughnut(topAndDown[0],crimeName[i],chartMain[i],colorList[i])
		}else{
			makeDoughnut(topAndDown[1],crimeName[i-6],chartMain[i-1],colorList[i-6])
		}
	}
}

createChart()
makeChart()
