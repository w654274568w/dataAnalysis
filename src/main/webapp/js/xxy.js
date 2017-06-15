/**
 * Created by adrain on 2016/3/2.
 */
;(function($){
    //写一个千位分符玩一下
    function toThousands(num){
        var num = (num || 0).toString(),
            result='',
            quantile = '';
        if(num.indexOf('.')>0){
            quantile = num.slice(num.indexOf('.'),num.length);
            num = num.slice(0,num.indexOf('.'));
        }
        while (num.length > 3){
            result = ',' + num.slice(-3) + result;
            num = num.slice(0,num.length-3);
        }
        if(num){
            result = num + result + quantile;
        }
        return result;
    }
    //网银支付和快捷支付选项卡切换事件
    $('#rechagePaymentUL > li').on('click',function(){
        //缓存当前元素，以及内容容器集合元素
        var $that = $(this),
            $itmes = $(this).parent().siblings('.mode-item');

        //缓存当前点击元素在li中的索引位置。
        var index = $that.index();

        //切换显示内容
        $itmes.hide().eq(index).show();
        //给选项卡加效果
        $that.addClass('active').siblings().removeClass('active');
        return false;
    });
    //银行支付页面 充值银行列表选择事件
    $("#banks > .bank").on("click", function(e) {
        //缓存银行支付额度表格元素集.
        var $that = $(this),
            $banks = $("#bank_collections > .center");

        //隐藏所有的支付额度表格，筛选出当前单选项匹配的，并显示出来.
        $banks.hide().filter("[data-name='" + ($that.attr("data-name")) + "']").show();

        //给选中的银行加效果.
        $that.addClass("active").siblings().removeClass("active");

        $('#ceshi').on('click',function(){
            if($that.hasClass('active')){
                alert($that.attr('data-name'));
            }
        });
    });


    //快捷支付是否选中状态切换
    $('#quickBankBox').on('click',function(){
        $(this).hasClass('active') ? $(this).removeClass('active') : $(this).addClass('active');
    });
    //关闭弹层单击函数
    function winCloseAll() {
        $(".popup-mask, .popup").hide();
        return false;
    }
    //关闭按钮单击事件.
    $(".popup").find("[data-action='close']").on("click", function() {
        //关闭自己的弹窗层和遮罩层.
        winCloseAll();
        return false;
    });

    //写一个通用的选项卡切换呢
    $('#tabTit').children().on('click',function(){
        //缓存当前元素，以及内容容器集合元素
        var $that = $(this),
            $itmes = $('#tabItem').children('.item');

        //缓存当前点击元素在li中的索引位置。
        var index = $that.index();

        //切换显示内容
        $itmes.hide().eq(index).show();
        //给选项卡加效果
        $that.addClass('active').siblings().removeClass('active');
        return false;
    });

    //点击眼睛图标显示或隐藏密码
    $('#passwordEye').on('click',function(){
        var $that = $(this);
        if($('#password').attr('type') == 'password'){
            $that.removeClass('password-eye-close');
            $('#password').attr('type','text');
        }else if($('#password').attr('type') == 'text'){
            $that.addClass('password-eye-close');
            $('#password').attr('type','password');
        }
    });
    //上传包装file
    //$('input[id=lefile]').change(function(){
    //    $('#photoCover').val($(this).val());
        /*
        ps:html代码
        <input id="lefile" type="file" style="display: none;">
            <div class="input-append">
            <input id="photoCover" class="input-large" type="text">
            <a class="btn btn-default" onclick="$('input[id=lefile]').click();">选择图片</a>
        </div>
        */
    //});
    //加入我们和帮助中心的标题内容显示隐藏
    var ahTabDlts = $('#ahTabDl').find('dt');
    //ahTabDlts.eq(0).next().show();
    ahTabDlts.each(function(){
        $(this).click(function(){
            if( $(this).next().is(':hidden')){
                $(this).addClass('active').next().slideDown();
            }else{
                $(this).removeClass('active').next().slideUp();
            }
        });
    });
    //滚动的时候才显示向上回到顶部箭头
    /*$(window).scroll(function(){
        if ($(window).scrollTop()>100){
            $("#rightDownSlide > .arrowtop").show();
        }
        else
        {
            $("#rightDownSlide > .arrowtop").hide();
        }
    });*/
    //当点击跳转链接后，回到页面顶部位置
    $("#rightDownSlide > .arrowtop").on('click',function(){
        $('body,html').animate({scrollTop:0},1000);
        return false;
    });

    //找到滑过文字提示
    var dataTips = $('[data-tip]');

    dataTips.hover(function(){
        var dataTipHtml = $.trim($(this).html()) ;//找到当前显示利率
        var dataTipDivCon = '<div class="tooltip">' + //滑过要加显示的东东
            $(this).attr('data-tip')+
            '</div>';
        if($(this).closest('li')){
            $(this).closest('li').css({
                'z-index':2
            });
        };
        $(this).html(dataTipHtml+dataTipDivCon);

    },function(){
        //var dataTipHtml = $(this).find('.tooltip span').html();

        if($(this).closest('li')){
            $(this).closest('li').css({
                'z-index':1
            });
        };
        $(this).html('');
    });

})(jQuery)



