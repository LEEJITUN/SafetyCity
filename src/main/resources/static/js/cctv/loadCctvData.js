window.addEventListener('DOMContentLoaded', event => {
    const datatablesSimple = document.getElementById('datatablesSimple');
    let dataTable = new simpleDatatables.DataTable(datatablesSimple);

    let area = document.getElementById('table_area').value;

    let loadData = (area) => {
        fetch("/api/cctv?area=" + area)
            .then((res) => res.json())
            .then((datas) => {
                if(dataTable) dataTable.destroy();

                let content = datas.content;

                let obj = {
                    headings: Object.keys(content[0]),
                    data: []
                };

                for ( let i = 0; i < content.length; i++ ) {

                    obj.data[i] = [];

                    for (let p in content[i]) {
                        if(content[i].hasOwnProperty(p) ) {
                            obj.data[i].push(content[i][p]);
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




