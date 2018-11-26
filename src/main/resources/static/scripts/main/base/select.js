function TableTest() {
    $('#sorti').bootstrapTable({
        method: 'post',
        url: "/index",//请求路径
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        striped: true, //是否显示行间隔色
        pageNumber: 1, //初始化加载第一页
        pagination: true,//是否分页
        sidePagination: 'client',//server:服务器端分页|client：前端分页
        pageSize: 10,//单页记录数
        pageList: [5, 10, 20, 30],//可选择单页记录数
        showRefresh: true,//刷新按钮
        queryParams: function (params) {//上传服务器的参数
            var temp = {
                questionName: $('#search_name').val(),
            };
            return temp;
        },
        columns: [{
            title: '投票名称',
            field: 'questionName',
            sortable: true
        }, {
            title: '类别',
            field: 'type',

        }, {
            title: '截止时间',
            field: 'time',
        }, {
            title: '投票数量',
            field: 'count',
            formatter: formatSex,//对返回的数据进行处理再显示
        }, {
            title: '操作',
            field: 'questionId',
            formatter: operation,//对资源进行操作
        }]
    });
}
$(function(){
    TableTest();  //初始化载入表格
    $('#search_btn').on('click',function() {
        $('#sorti').bootstrapTable('refresh', {
            url : '/index'
        });
    })
});
//value代表该列的值，row代表当前对象
function formatSex(value, row, index) {
    return value == 1 ? "匿名投票" : "非匿名投票";
    //或者 return row.sex == 1 ? "男" : "女";
}

//删除、编辑操作
function operation(value, row, index) {
    var htm = "<button>投票</button>"
    return htm;
}

//查询按钮事件
$('#search_btn').click(function() {
    $('#sorti').bootstrapTable('refresh', {
        url : '/index'
    });
})

/*
$('#sorti').bootstrapTable({
    method : 'get',
    url : "user/getVoteListPage",//请求路径
    striped : true, //是否显示行间隔色
    pageNumber : 1, //初始化加载第一页
    pagination : true,//是否分页
    sidePagination : 'client',//server:服务器端分页|client：前端分页
    pageSize : 10,//单页记录数
    pageList : [ 5, 10, 20, 30 ],//可选择单页记录数
    showRefresh : true,//刷新按钮
    queryParams : function(params) {//上传服务器的参数
        var temp = {
            name : $('#search_name').val(),
        };
        return temp;
    },
    columns : [ {
        title : '投票名称',
        field : 'QuestionName',
        sortable : true
    }, {
        title : '类别',
        field : 'type',

    }, {
        title : '截止时间',
        field : 'time',
    }, {
        title : '投票数量',
        field : 'count',
        formatter : formatSex,//对返回的数据进行处理再显示
    }, {
        title : '操作',
        field : 'id',
        formatter : operation,//对资源进行操作
    } ]
})

//value代表该列的值，row代表当前对象
function formatSex(value, row, index) {
    return value == 1 ? "匿名投票" : "非匿名投票";
    //或者 return row.sex == 1 ? "男" : "女";
}

//删除、编辑操作
function operation(value, row, index) {
    var htm = "<button>删除</button><button>修改</button>"
    return htm;
}

//查询按钮事件
$('#search_btn').click(function() {
    $('#sorti').bootstrapTable('refresh', {
        url : 'user/getVoteListPage'
    });
})

*/
