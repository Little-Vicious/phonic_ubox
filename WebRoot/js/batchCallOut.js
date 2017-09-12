/**
 * 批量外呼页面js
 */
    var select;
      $(function($) {
        initPage();
      });
      
      function stopCall(){
        var callNo = $("#callNo").val();
        console.log("====已挂机");
        //呼叫完成之后
        //先保存数据
        $.ajax({
          url:"effeiveAction.do",
          type:"POST",
          dataType:"json",
          data:{
            "callNo": callNo
            },
            success:function(msg){
              console.log(JSON.stringify(msg));
            },
            error: function(er) {
              console.log(JSON.stringify(er));
            }
        });
        //再打开窗口
        var obj = $("#callBtn");
        PopLayer(obj);
      }

      //页面初始化方法
      function initPage() {
        resetPage();
        var batchNo = $("#batchNo").val();
        $.ajax({
          url: "getCallOutInfo.do",
          type: "POST",
          data: {
            "batchNo": batchNo
          },
          dataType: "json",
          success: function(msg) {
            var str = JSON.stringify(msg);
            var obj = eval('(' + str + ')');
            
            var batchcalloutCustom = obj.batchcalloutCustom;
            var callOutCustom = obj.callOutCustom;
            var customernumbers = obj.customernumbers;
            initCentent(batchcalloutCustom, callOutCustom, customernumbers);
          },
          error: function(er) {
            console.log(JSON.stringify(er));
          }
        });
      }

      //重置赋值项
      function resetPage() {
        select = $("#otherNumber");
        var centent = $("#centent");
        select.empty();
        centent.empty();
      }

      //为页面标签赋值
      function initCentent(batchcalloutCustom, callOutCustom, customernumbers) {
        $("#custName").val(callOutCustom.custName);
        $("#custNumber").val(callOutCustom.custNumber);
        
        select = $("#otherNumber");
        select.append("<option value=''>---请选择---</option>");
        for(var i = 0; i < customernumbers.length; ++i) {
          var customernumber = customernumbers[i];
          select.append("<option value=" + customernumber.custNumber + ">" + customernumber.custNumber + "</option>");
        }

        var content = "<pre>总数：";
        content += batchcalloutCustom.countCallout;
        content += "未完成：" + batchcalloutCustom.countUnfinish
        content += "已完成：" + batchcalloutCustom.countFinish
        content += " 已完成有效：" + batchcalloutCustom.countEffective
        content += "</pre>";
        $("#centent").append(content);
        $("#callout_id").val(callOutCustom.id);
      }
      
      //开始外呼事件
      function callOut() {
        if($("#custName").val() ? false : true) {
          alert("客户姓名 不能为空！");
          return false;
        }

        if($("#custNumber").val() ? false : true) {
          alert("客户电话 不能为空！");
          return false;
        }

        stats = checkStats(uboxhdl);
        if(stats != -2) {
          if(checkStats(uboxhdl) != 3) {
            alert("请先摘机");
            return false;
          }else {
            setStartTime();
            startCall();
            return true;
          }
          
        } else {
          return false;
        }
        
        /*setStartTime();
        startCall();
        return true;*/

      }
      
      //点击呼叫按钮为开始时间赋值，病置灰按钮
      function setStartTime(){
        curTime = new Date();
        $("#starttime").val(curTime);
        $("#starttimeDiv").append(curTime.pattern("yyyy-MM-dd hh:mm:ss"));
        $("#callBtn").attr({
          'disabled': 'disabled'
        });
        $("#nextBtn").attr("disabled", true);
      }
      
      //开始呼叫
      function startCall(){
        select = $("#otherNumber");
        //呼叫过程
        var phoneNumber;
        var selectText = select.find("option:selected").val();
        var callNumber = $("#custNumber").val();
        phoneNumber = ''==selectText?callNumber:selectText;
        ubox_dialnum(phoneNumber);
        //stopCall();
      }

      //下一个按钮
      function nextCall() {
        var callNo = $("#callNo").val();
        $.ajax({
          url: "nextAction.do",
          type: "POST",
          data: {
            "callNo": callNo
          },
          dataType: "json",
          success: function(msg) {
            initPage();
          },
          error: function(er) {
            console.log(JSON.stringify(er));
          }
        });

      }
      
      
      //播放录音
      function playRec(){
        var  filename = "D:\\record\\OUT_2017-8-4-11-44-18.wav";
        ubox_playfile(filename);
        $("#recFlag").val(true);
      }
      
      //客户评价
      function appraiseCall(responseCode){
        alert("客户评价："+responseCode);
      }