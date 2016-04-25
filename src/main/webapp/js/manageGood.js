/*


*/
var table =$("#dataTable").DataTable({
    "lengthChange": false,
    "searching": true,
    "autoWidth": false,
    bJQueryUI:true,
    ajax: {
        url: '/key/good/myGood.json',
        type : 'post',
        dataSrc: function ( json ) {
            if(json.msg!=""){
                alert(json.msg);
            }
            if(json.goto!=""){
                window.location.href=json.goto;
            }
            return json.data;
        },
        data :{}
    },
    rowId: 'id',
    columns:[
        {"data": "goodname" },
        {"data": "palce"},
        {"data": "price"},
        {"data": "number"},
        {"data": "point"},
        {"data": "tradeNum"},
        {"data": "judge"}
    ],
});
$('#dataTable tbody').on( 'click', 'tr', function () {
    if ($(this).hasClass('selected') ) {
        var id = table.row( this ).id();
        alert(id);
        $(this).removeClass('selected');
    }
    else {
        table.$('tr.selected').removeClass('selected');
        $(this).addClass('selected');
    }
} );