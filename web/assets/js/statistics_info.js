var comName = [];
var comNum = [];
var bgColor = [];
var bgBorderColor = [];
var num;

$.ajax({
    type: "POST",
    url: "/action/companyDB.do?act=statistics",
    dataType: "json",
    success: function(data){
        for ( var i = 0; i <data.possession.length; i++){
            comName[i] = data.possession[i].comName;
            comNum[i] = data.possession[i].num;

            var rgba = 'rgba(';
            for (var j=0;j<3;j++){
                var num = Math.random()*255;
                rgba += parseInt(num, 10)+",";
            }
            bgColor[i] = rgba+'0.2)';
            bgBorderColor[i] = rgba+'1)';
        }
        console.log(comName,comNum,bgColor,bgBorderColor);
        var ctx = document.getElementById("statistics-bar").getContext('2d');
        var myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: comName,
                datasets: [{
                    label: '拥有办公室的数量',
                    data: comNum,
                    backgroundColor: bgColor,
                    borderColor: bgBorderColor,
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero:true
                        }
                    }]
                }
            }
        });
    },
    error: function(){
        alert("加载失败");
    }
});

