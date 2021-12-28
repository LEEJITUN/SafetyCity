window.addEventListener('DOMContentLoaded', event => {
    const datatablesSimple = document.getElementById('datatablesSimple');
    let dataTable = new simpleDatatables.DataTable(datatablesSimple);

    let area = document.getElementById('table_area').value;

    let loadData = (area) => {
        fetch("/api/cctv?area=" + area)
            .then((res) => res.json())
            .then((datas) => {
                dataTable.destroy();

                let obj = {
                    headings: Object.keys(datas[0]),
                    data: []
                };

                for ( let i = 0; i < datas.length; i++ ) {

                    obj.data[i] = [];

                    for (let p in datas[i]) {
                        if(datas[i].hasOwnProperty(p) ) {
                            obj.data[i].push(datas[i][p]);
                        }
                    }
                }
                dataTable = new simpleDatatables.DataTable(datatablesSimple, {data: obj});
            });
    }

    loadData(area);

    document.getElementById('table_area').addEventListener('change', () => {
        area = document.getElementById('table_area').value;
        loadData(area);
    });
});




