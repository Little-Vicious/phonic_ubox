function initDrop(jsonStr) {
  var str = JSON.stringify(jsonStr);

  var obj = eval('(' + str + ')');
  var params = obj.data;

  for(var i = 0; i < params.length; ++i) {
    var selectIds = params[i].selectIds;
    var typeCode = params[i].typeCode;
    initCode(selectIds, typeCode);
  }

}

function initCode(selectIds, typeCode) {
  $.ajax({
    url: getContextPath() + "/groupCommon/getInitCodeByType.do",
    type: "POST",
    data: {
      "typeCode": typeCode
    },
    dataType: "json",
    success: function(msg) {
      var str = JSON.stringify(msg);

      var obj = eval('(' + str + ')');
      var codeType = obj.codeType;
      var custInfo = obj.custInfo;

      var typeCode = codeType.typeCode;
      var select = $("#" + selectIds);
      var listCodeInfo = codeType.listCodeInfo;

      for(var i = 0; i < listCodeInfo.length; ++i) {
        var codeinfo = listCodeInfo[i];
        codevalue = codeinfo.codeValue;
        codename = codeinfo.codeName;
        if(1 == 0){
          select.append("<option selected='selected' value=" + codevalue + ">" + codename + "</option>");
        }else{
          select.append("<option value=" + codevalue + ">" + codename + "</option>");
        }
        
      }
    },
    error: function(er) {
      console.log(JSON.stringify(er));
    }
  });
}

function getContextPath() {
  var pathName = document.location.pathname;
  var index = pathName.substr(1).indexOf("/");
  var result = pathName.substr(0, index + 1);
  return result;
}