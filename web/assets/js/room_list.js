const $table = $('#room_table');
const $remove = $('#remove');
let selections = [];

$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();

});


var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $table.bootstrapTable({
            url: "/action/getDataList.do?act=GetRoomList",                 //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            // sortable: true,                     //是否启用排序
            // sortOrder: "asc",                   //排序方式
            queryParamsType : "undefined",
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100, 200],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            //strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            // clickToSelect: true,                //是否启用点击选中行
            height: 550,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            /**/
            columns: [
                {
                    field: 'state',
                    checkbox: true,
                    align: 'center',
                    valign: 'middle'
                }, {
                    field: 'id',
                    title: '办公室编号',
                    // sortable: true,
                    align: 'center',
                    valign: 'middle'
                },{
                    field: 'comName',
                    title: '单位名称',
                    align: 'center',
                    valign: 'middle'
                },{
                    field: 'situation',
                    title: '收租情况',
                    align: 'center',
                    valign: 'middle',
                },{
                    field: 'money',
                    title: '租金(￥)',
                    align: 'center',
                    valign: 'middle',
                },{
                    field: 'operate',
                    title: '操作',
                    align: 'center',
                    valign: 'middle',
                    events: operateEvents,
                    formatter: operateFormatter
                }
            ]

        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageNumber: params.pageNumber,   //页面大小
            pageSize: params.pageSize,  //页码
            searchText: params.searchText,
            //departmentname: $("#txt_search_departmentname").val(),
            //statu: $("#txt_search_statu").val()
        };
        return temp;
    };
    return oTableInit;
};

var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };
    return oInit;
};

//超时刷新
setTimeout(() => {
    $table.bootstrapTable('resetView');
}, 200);

$table.on('check.bs.table uncheck.bs.table ' +
    'check-all.bs.table uncheck-all.bs.table', () => {
    $remove.prop('disabled', !$table.bootstrapTable('getSelections').length);
    // save your data, here just save the current page
    selections = getIdSelections();
    // push or splice the selections if you want to save all data selections
});
//所有的事件都会触发，记录选中的行
$table.on('all.bs.table', (e, name, args) => {
    console.log(name, args);
});

//得到所选的列
function getIdSelections() {
    return $.map($table.bootstrapTable('getSelections'), ({id}) => id);
}
//绘制行按钮
function operateFormatter(value, row, index) {
    return [
        '<a class="modify" href="javascript:void(0)" title="修改">',
        '<i class="glyphicon glyphicon-cog"></i>',
        '</a>  ',
        '<a class="remove" href="javascript:void(0)" title="删除">',
        '<i class="glyphicon glyphicon-remove"></i>',
        '</a>'
    ].join('');
}
//选单 按钮删除
$remove.click(() => {
    const ids = getIdSelections();
    //jquery_ajax传要删除的room
    $.ajax("/action/roomDB.do?act=delete&id="+ids,true);
    $table.bootstrapTable('remove', {
        field: 'id',
        values: ids
    });
    $remove.prop('disabled', true);
});

//行按钮点击事件
window.operateEvents = {
    //行修改按钮事件
    'click .modify': function (e, value, {id}, index) {
        // alert(`You click like action, row: ${JSON.stringify(row)}`);
        $("#roomModel").modal({
            keyboard:true,
            backdrop:false,
            remote: "/pages/model/room_modify_model.jsp?id="+[id]
        });
    },
    //行删除按钮事件
    'click .remove': function(e, value, {id}, index) {
        //数据库中删除
        var xmlhttp;
        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest();
        }
        else{
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.open("GET","/action/roomDB.do?act=delete&id="+[id],true);
        xmlhttp.send();

        //table上消失
        $table.bootstrapTable('remove', {
            field: 'id',
            values: [id]
        });
    }
};

//add模拟弹出框
$(function(){
    $("#add").click(function(){
        $("#roomModel").modal({
            keyboard:true,
            backdrop:false,
            remote: "/pages/model/room_add_model.jsp"
        });
    });
});
//移除模拟弹出框数据
$("#roomModel").on("hidden.bs.modal", function() {
    $(this).removeData("bs.modal");
});
