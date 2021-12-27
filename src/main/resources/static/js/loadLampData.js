window.addEventListener('DOMContentLoaded', event => {
    const datatablesSimple = document.getElementById('datatablesSimple');
    const datatableBody = document.getElementById('datatablesBody');
    const datatableThread = document.getElementById('datatableThread');

    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki
    var _thread_ = document.createElement('thread'),
        _tr_ = document.createElement('tr'),
        _th_ = document.createElement('th'),
        _td_ = document.createElement('td');
// Builds the HTML Table out of myList json data from Ivy restful service.
    function buildHtmlTable(arr) {
        var table = datatablesSimple;
        var body = datatableBody;
        var columns = addAllColumnHeaders(arr);

        for (var i = 0, maxi = arr.length; i < maxi; ++i) {
            var tr = _tr_.cloneNode(false);
            for (var j = 0, maxj = columns.length; j < maxj; ++j) {
                var td = _td_.cloneNode(false);
                cellValue = arr[i][columns[j]];
                td.appendChild(document.createTextNode(arr[i][columns[j]] || ''));
                tr.appendChild(td);
            }
            body.appendChild(tr);
        }
        return table;
    }
// Adds a header row to the table and returns the set of columns.
// Need to do union of keys from all records as some records may not contain
// all records
    function addAllColumnHeaders(arr) {
        var columnSet = [],
            tr = _tr_.cloneNode(false);
        for (var i = 0, l = arr.length; i < l; i++) {
            for (var key in arr[i]) {
                if (arr[i].hasOwnProperty(key) && columnSet.indexOf(key) === -1) {
                    columnSet.push(key);
                    var th = _th_.cloneNode(false);
                    th.appendChild(document.createTextNode(key));
                    tr.appendChild(th);
                }
            }
        }
        datatableThread.appendChild(tr);
        return columnSet;
    }


    fetch("/api/lamp")
        .then((res) => res.json())
        .then((datas) => {
            let content = datas.content
            new simpleDatatables.DataTable(buildHtmlTable(content));
        });
});




