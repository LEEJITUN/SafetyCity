let curr_area = document.getElementById('curr-area');
let container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
let options = { //지도를 생성할 때 필요한 기본 옵션
    center: new kakao.maps.LatLng(37.5502,126.982), //지도의 중심좌표.
    level: 8 //지도의 레벨(확대, 축소 정도)
};

let cctvCnt = 0;
let emerbellCnt = 0;
let safetyhouseCnt = 0;

let map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

// 지도를 클릭한 위치에 표출할 마커입니다
let marker = new kakao.maps.Marker({
    // 지도 중심좌표에 마커를 생성합니다
    position: map.getCenter()
});

// 마커 이미지의 이미지 주소입니다
let imageSrc = "https://cdn2.iconfinder.com/data/icons/wsd-map-markers-2/512/wsd_markers_89-1024.png";

let houseimageSrc = "https://cdn-icons-png.flaticon.com/512/25/25694.png";

let emercallimageSrc = "https://cdn0.iconfinder.com/data/icons/security-double-color-red-and-black-vol-1/52/alarm__alert__light__emergency-1024.png";

let markers = [];

// 배열에 추가된 마커들을 지도에 표시하거나 삭제하는 함수입니다
function setMarkers(map) {
    for (let i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }
}

// "마커 감추기" 버튼을 클릭하면 호출되어 배열에 추가된 마커를 지도에서 삭제하는 함수입니다
function hideMarkers() {
    setMarkers(null);
}

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
    curr_area.innerHTML = '';
    hideMarkers();

    // 클릭한 위도, 경도 정보를 가져옵니다
    let latlng = mouseEvent.latLng;

    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);

    marker.setMap(map);

    fetch("/api/cctv/areacnt?lat="+latlng.getLat()+"&lng="+latlng.getLng())
        .then((res) => res.json())
        .then((datas) => {
            let positions = [];
            datas.map((data) => {
                let tmp = {
                    title: data.address,
                    latlng: new kakao.maps.LatLng(data.wgs_x, data.wgs_y)
                }
                positions.push(tmp);
            });
            for (let i = 0; i < positions.length; i ++) {
                // 마커 이미지의 이미지 크기 입니다
                let imageSize = new kakao.maps.Size(15, 15);

                // 마커 이미지를 생성합니다
                let markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

                // 마커를 생성합니다
                let marker = new kakao.maps.Marker({
                    map: map, // 마커를 표시할 지도
                    position: positions[i].latlng, // 마커를 표시할 위치
                    title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                    image : markerImage // 마커 이미지
                });
                markers.push(marker);

            }
            cctvCnt = datas.length
            curr_area.innerHTML += 'CCTV : ' + datas.length + ' 개 ' + '<br>';
        })

    fetch("/api/safetyhouse/areacnt?lat="+latlng.getLat()+"&lng="+latlng.getLng())
        .then((res) => res.json())
        .then((datas) => {
            let positions = [];
            datas.map((data) => {
                let tmp = {
                    title: data.address,
                    latlng: new kakao.maps.LatLng(data.wgs_x, data.wgs_y)
                }
                positions.push(tmp);
            });
            for (let i = 0; i < positions.length; i ++) {
                // 마커 이미지의 이미지 크기 입니다
                let imageSize = new kakao.maps.Size(25, 25);

                // 마커 이미지를 생성합니다
                let markerImage = new kakao.maps.MarkerImage(houseimageSrc, imageSize);

                // 마커를 생성합니다
                let marker = new kakao.maps.Marker({
                    map: map, // 마커를 표시할 지도
                    position: positions[i].latlng, // 마커를 표시할 위치
                    title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                    image : markerImage // 마커 이미지
                });
                markers.push(marker);
            }
            safetyhouseCnt = datas.length;
            curr_area.innerHTML += '여성안전지킴이집 : ' + datas.length + ' 개' + '<br>';
        })

    fetch("/api/emercall/areacnt?lat="+latlng.getLat()+"&lng="+latlng.getLng())
        .then((res) => res.json())
        .then((datas) => {
            let positions = [];
            datas.map((data) => {
                let tmp = {
                    title: data.address,
                    latlng: new kakao.maps.LatLng(data.wgs_x, data.wgs_y)
                }
                positions.push(tmp);
            });
            for (let i = 0; i < positions.length; i ++) {
                // 마커 이미지의 이미지 크기 입니다
                let imageSize = new kakao.maps.Size(15, 15);

                // 마커 이미지를 생성합니다
                let markerImage = new kakao.maps.MarkerImage(emercallimageSrc, imageSize);

                // 마커를 생성합니다
                let marker = new kakao.maps.Marker({
                    map: map, // 마커를 표시할 지도
                    position: positions[i].latlng, // 마커를 표시할 위치
                    title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                    image : markerImage // 마커 이미지
                });
                markers.push(marker);
            }
            emerbellCnt = datas.length;
            curr_area.innerHTML += '안전비상벨 : ' + datas.length + ' 개' + '<br>';
        });
});



