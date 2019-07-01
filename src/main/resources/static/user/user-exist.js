//ajax请求后端判断所添加的管理员是否已近存在
$(function () {
    // 失焦触发
    $('#userName').blur(function () {
        var userName = $('#userName').val();  // 获取姓名
        if(userName){
            $.ajax({
                url:'/user/exist',
                type:'get',
                data:{
                    username:userName
                },
                success:function (message) {
                    if (message == 'true'){
                        $('#message').show();
                        $("#submit-button").attr('disabled',true);

                    }
                    else if (message == 'false'){
                        $('#message').hide();
                        $("#submit-button").attr('disabled',false);
                        $('#submit-button').attr("type","submit");
                    }
                }
            })
        }
    })
});

// 返回列表
$(function () {
    $("#backid").click(function () {
        window.location.href = '/user/list/1'
    })
})
