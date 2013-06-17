/*
webroot用来指定web根目录
*/
var webroot="zsgx";

/*
	常用正则表达式
*/
var PATTERN_EMAIL="\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
var PATTERN_CHINESE_CHAR="[\u4e00-\u9fa5]";
var PATTERN_DOUBLEBYTE_CHAR="[^\x00-\xff]";

String.prototype.endWith=function(str){
	if(str==null||str==""||this.length==0||str.length>this.length)
	return false;
	if(this.substring(this.length-str.length)==str)
	return true;
	else
	return false;
	return true;
	}

	String.prototype.startWith=function(str){
	if(str==null||str==""||this.length==0||str.length>this.length)
	return false;
	if(this.substr(0,str.length)==str)
	return true;
	else
	return false;
	return true;
	}

String.prototype.vbtrim = function()
{
	return this.replace(/(^\s*)|(\s*$)/g, "");
}
/*
	字节长度
*/
String.prototype.len=function(){
	return this.replace(/[^\x00-\xff]/g,"aa").length;
}


function lTrim(sString)
{
	var i;
	if (sString.length < 1)
		return "";
	for (i = 0; i < sString.length; i++)
		if (sString.charAt(i) != " ")
			break;
	if (i >= sString.length)
		return("");
	else
		return(sString.substring(i, sString.length));
}
function rTrim(sString)
{
	var i;
	if (sString.length < 1)
		return "";
	for (i = (sString.length - 1); i >= 0; i--)
		if (sString.charAt(i) != " ")
			break;
	if (i < 0)
		return("");
	else
		return(sString.substring(0, i + 1));
}
function allTrim(sString)
{
	if (sString.length < 1)
		return "";
	var dString = lTrim(sString);
	dString = rTrim(dString);
	return dString;
}
function isEmpty(sString)
{
	var s = allTrim(sString);
	if (s.length < 1)
		return true;
	else
		return false;
}
function getLength(sString)
{
	var s = allTrim(sString);
	return s.length;
}

function getByteLength(sString){
  if(sString==null)
    return 0;
  if(sString.length==0)
    return 0;

  var sEscape = escape(sString);
  var iLen = sString.length;
  var iUnicodeCount = getInStringCount(sEscape,"%u");

  return iLen+iUnicodeCount;
}

function getInStringCount(src,patten){
  var pos1 = src.indexOf(patten);
  if(pos1<0) return 0;

  var sSplits = src.split(patten);
  return sSplits.length-1;
}

function replace(sSource, sFind, sReplace)
{
	var pos1 = sSource.indexOf(sFind);
	while (pos1 >= 0)
	{
		if ((pos1 + sFind.length) >= sSource.length)
		{
			sSource = sSource.substring(0, pos1) + sReplace;
		}
		else
		{
			sSource = sSource.substring(0, pos1) + sReplace + sSource.substring(pos1 + sFind.length, sSource.length);
		}

		pos1 = sSource.indexOf(sFind,pos1);
	}
	return sSource;
}

function isNumberPatten(src,sPatten){
  var arr;
  arr = sPatten.split(".");
  if(arr.length==1){
      return isNumber(src,arr[0].length,0);
  }else{
      return isNumber(src,arr[0].length+arr[1].length,arr[1].length);
  }

}

function isNumber(src,precision,scale){
  var integer_part = precision - scale;

  if (integer_part < 0 || precision < 0 || scale < 0)
              return false;

  var patten;

  if (scale > 0) {
    patten = "^-?\\d{1," + integer_part + "}(\\.\\d{1," + scale + "})?$";
  }
  else {
    patten = "^-?\\d{1," + integer_part + "}$";
  }

  return Matchs(src, patten);
}

function Matchs(src,patten){
  var re;                     // 声明变量。
  re = new RegExp(patten,"g");  // 创建正则表达式对象。
  return re.test(src);
}

function isNumeric(sString)
{
	var s = allTrim(sString);
	if (isNaN(s) == true)
		return false;
	else
		return true;
}
function isInt(sString)
{
	var s = allTrim(sString);
	if (isNumeric(s) == false)
		return false;

	if ((s % 1) == 0)
		return true;
	else
		return false;
}
function DateIsValid(yy, mm, dd)
{
	var t, d, s, minDate, maxDate;

	d = new Date(yy, mm - 1, dd);
	if (isNaN(yy) || isNaN(mm) || isNaN(dd))
		return new Date();

	minDate = new Date(1970, 0, 1);
	maxDate = new Date(9999, 11, 31);
	if (d < minDate)
		d = minDate;
	if (d > maxDate)
		d = maxDate;
	return d;
}
function DateIsValid1(strDate)
{
	strDate = replace(strDate, "-", "/");
	var i = Date.parse(strDate);
        alert(i);

	if (isNaN(i))
		return "";

	var minDate = Date.parse("1/1/1970");
	var maxDate = Date.parse("12/31/9999");

	if (i > maxDate || i < minDate)
		return "";

	var d = new Date(i);
	var s = d.getYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();

        return s;
}

//日期格式：YYYY-MM-DD
function isDate(strDate){
   var strSeparator = "-"; //日期分隔符
   var strDateArray;
   var intYear;
   var intMonth;
   var intDay;
   var boolLeapYear;

   strDateArray = strDate.split(strSeparator);
   if(strDateArray.length!=3) return false;

   // 月日的长度必须是2
   if(strDateArray[1].length!=2) return false;
   if(strDateArray[2].length!=2) return false;

   intYear = parseInt(strDateArray[0],10);
   intMonth = parseInt(strDateArray[1],10);
   intDay = parseInt(strDateArray[2],10);

   if(isNaN(intYear)||isNaN(intMonth)||isNaN(intDay)) return false;

   if(intMonth>12||intMonth<1) return false;

   if((intMonth==1||intMonth==3||intMonth==5||intMonth==7||intMonth==8||intMonth==10||intMonth==12)&&(intDay>31||intDay<1)) return false;

   if((intMonth==4||intMonth==6||intMonth==9||intMonth==11)&&(intDay>30||intDay<1)) return false;

   if(intMonth==2){
      if(intDay<1) return false;

      boolLeapYear = false;
      if((intYear%100)==0){
         if((intYear%400)==0) boolLeapYear = true;
      }
      else{
         if((intYear%4)==0) boolLeapYear = true;
      }

      if(boolLeapYear){
         if(intDay>29) return false;
      }
      else{
         if(intDay>28) return false;
      }
   }

   return true;
}

//日期格式：YYYY-MM-DD
//与上一函数的区别在于本函数没有日月长度的限制
function isDate2(strDate){
   var strSeparator = "-"; //日期分隔符
   var strDateArray;
   var intYear;
   var intMonth;
   var intDay;
   var boolLeapYear;

   strDateArray = strDate.split(strSeparator);

   if(strDateArray.length!=3) return false;

   intYear = parseInt(strDateArray[0],10);
   intMonth = parseInt(strDateArray[1],10);
   intDay = parseInt(strDateArray[2],10);

   if(isNaN(intYear)||isNaN(intMonth)||isNaN(intDay)) return false;

   if(intMonth>12||intMonth<1) return false;

   if((intMonth==1||intMonth==3||intMonth==5||intMonth==7||intMonth==8||intMonth==10||intMonth==12)&&(intDay>31||intDay<1)) return false;

   if((intMonth==4||intMonth==6||intMonth==9||intMonth==11)&&(intDay>30||intDay<1)) return false;

   if(intMonth==2){
      if(intDay<1) return false;

      boolLeapYear = false;
      if((intYear%100)==0){
         if((intYear%400)==0) boolLeapYear = true;
      }
      else{
         if((intYear%4)==0) boolLeapYear = true;
      }

      if(boolLeapYear){
         if(intDay>29) return false;
      }
      else{
         if(intDay>28) return false;
      }
   }

   return true;
}

//检查日期格式：YYYY-MM-DD hh:mm
function isLongDate1(strDate) {
	var intHour;
	var intMinute;

	//检查长度，如果不是16，则报错
	if(strDate.length != 16) return false;

	//	检查前10位是否是形如YYYY-MM-DD的日期格式
	var date1 = strDate.substr(0,10);
	if(!isDate(date1))	return false;

	//	检查时分妙部分是否正确，最大表示为23:59
	intHour = parseInt(strDate.substr(11,2));
	intMinute = parseInt(strDate.substr(14,2));
	if(isNaN(intHour)||isNaN(intMinute)) return false;
	if(intHour > 23) return false;
	if(intMinute > 59) return false;

	return true;
}

function ValidEmail(item)
{
/*
this function is progammed by wang haitao and updated by Fan Yuansheng
*/
	var etext
	var elen
	var i
	var aa
	etext=item
	elen=etext.length
	if (elen<5)
		return true;
	i= etext.indexOf("@",0)
	if (i==0 || i==-1 || i==elen-1)
		return true;
	if (etext.indexOf("@",i+1)!=-1)
		return true;
	if (etext.indexOf("..",i+1)!=-1)
		return true;
	i=etext.indexOf(".",0)
	if (i==0 || i==-1 || etext.charAt(elen-1)=='.')
		return true;
	if ( etext.charAt(0)=='-' ||  etext.charAt(elen-1)=='-')
		return true;
	if ( etext.charAt(0)=='_' ||  etext.charAt(elen-1)=='_')
		return true;
	for (i=0;i<=elen-1;i++)
		{
		 aa=etext.charAt(i)
		if (!((aa=='.') || (aa=='@') || (aa=='-') ||(aa=='_') || (aa>='0' && aa<='9') || (aa>='a' && aa<='z') || (aa>='A' && aa<='Z')))
			return true;
		}
	return false;
}

function testfun()
{
	alert('Hello world');
}

function DateToString(o_date)
{
	var s_date;
	s_date=(o_date.getMonth()+1)+'/'+o_date.getDate()+'/'+o_date.getYear();
	return s_date;
}

function isDataValid(DataType,DataValue)
{
	//此函数只处理以下数据类型
	//1.数字
	//2.字符
	//3.日期
	//4.整数
        var ret;

	if(DataType=="数字" || DataType=="整数" || DataType=="NUMBER" || DataType=="INTEGER" || DataType=="NUMERIC")
	{
	//	window.alert("type is numeric: "+ DataValue);
                ret = isNumeric(DataValue);
                if(!ret)
                  window.alert("请正确输入数字");
		return ;
	}

	if(DataType=="CHAR")
	{
	//	window.alert("type is char: "+ DataValue);
                ret = isEmpty(DataValue);
                if(ret)
                  window.alert("请输入值");
		return !ret;
	}

	if(DataType=="DATE")
	{
	//	window.alert("type is Date: "+ DataValue);
                ret = isDate(DataValue);
                if(!ret)
                  window.alert("日期输入有误，请检查日期输入格式\n\r4位年份，2位月份，2位日（YYYY-MM-DD）");
                return ret;
	}//
//	window.alert("type is unknown: "+ DataValue);
	return true;
}

function isDataValid2(DataType,DataValue,required)
{
	//此函数只处理以下数据类型
	//1.数字
	//2.字符
	//3.日期
	//4.整数

    //该函数能处理必输项
    var ret;

	if(DataType=="数字" || DataType=="整数" || DataType=="NUMBER" || DataType=="INTEGER" || DataType=="NUMERIC" )
	{

               // window.alert("type is numeric: "+ DataValue);
                if(isEmpty(DataValue) && !required) return true;
                if(isEmpty(DataValue) && required){
//                 window.alert("请输入值");
                 return false;}
                ret = isNumeric(DataValue);
//                if(!ret)
//                  window.alert("请正确输入数字");
		return ret;
	}

	if(DataType=="CHAR")
	{
                ret = isEmpty(DataValue);
                if(!required) return true;
                if(ret)
                  window.alert("请输入值");
		return !ret;
	}

	if(DataType=="DATE")
	{
                if(isEmpty(DataValue) && !required) return true;
                ret = isDate(DataValue);
                if(!ret)
                  window.alert("日期输入有误，请检查日期输入格式\n\r4位年份，2位月份，2位日（YYYY-MM-DD）");
                return ret;
	}

	if(DataType=="LONGDATE1")
	{
                if(isEmpty(DataValue) && !required) return true;
                ret = isLongDate1(DataValue);
                if(!ret)
                  window.alert("日期输入有误，请检查日期输入格式\n\r必须形如（YYYY-MM-DD hh:mm）");
                return ret;
	}
//	window.alert("type is unknown: "+ DataValue);
	return true;
}

function isDataValid3(DataType,DataValue)
{
        //此函数只处理以下数据类型
        //1.数字
        //2.字符
        //3.日期
        //4.整数
  //  只返回有效性校验（boolean型），而不提示出错信息
        var ret;

        if(DataType=="数字" || DataType=="整数" || DataType=="NUMBER" || DataType=="INTEGER" || DataType=="NUMERIC")
        {
                ret = isNumeric(DataValue);
                return ret;
        }

        if(DataType=="CHAR")
        {
                ret = isEmpty(DataValue);
                return !ret;
        }

        if(DataType=="DATE")
        {
              ret = isDate(DataValue);
              return ret;
        }
        return true;
}

function getFormatDateFormSfzhm(strSfzhm,delimiter){
  return FormatDate8T11(getDateFromSfzhm(strSfzhm),delimiter);
}

function getDateFromSfzhm(strSfzhm){
  return strSfzhm.substr(6,8);
}

function FormatDate8T11(strDate,delimiter){
  return strDate.substr(0,4) + delimiter + strDate.substr(4,2) + delimiter + strDate.substr(6,2);
}

function ValidateNull(form){
  var prop;

  for(var i=0;i< form.elements.length;i++){
    prop = form.elements[i];
    if(prop.name!=""){
      if(prop["className"]=="required"){
        if(isEmpty(prop["value"])){
          	if(typeof prop["alt"]!='undefined')
                	alert("\""+prop["alt"]+"\""+"必填！");
                else
                        alert("\""+prop["title"]+"\""+"必填！");
                prop.focus();
                return false;
        }
        if(prop["type"].toLowerCase()=="checkbox" && prop["checked"]==false){
                alert("\""+prop["alt"]+"\""+"必选！");
                return false;
        }
      }
    }
  }
  return ValidateLength(form);
}

function ValidateLength(form){
 var prop;
 var comment = null;
 var maxlength = null;
  for(var i=0;i< form.elements.length;i++){
    prop = form.elements[i];
    if(prop.type=="text"){
      if(prop.alt==null || prop.alt.length!=0){
        comment = prop.alt;
      }
      if(prop.title==null || prop.title.length!=0){
        comment = prop.title;
      }
      if(comment==null){
        comment='';
      }
      /*if(typeof prop.maxlength == "undefined"){*/
        maxlength = prop.maxLength;
      /*}else{
        maxlength = prop.maxlength;
      }*/

      if(maxlength!=null){
         if(getByteLength(prop.value)>maxlength){
          if(comment.length==0){
            alert("未知名字段长度不能大于"+maxlength + "位(中文字算2位)");
            prop.focus();
            prop.select();
            return false;
          }else{
            alert('"'+comment+'"长度不能大于'+maxlength + "位(中文字算2位)");
            prop.focus();
            prop.select();
            return false;
          }
        }
      }
    }
  }
  return true;
}

function GetDictionaryContent(str,sel,nullvaluetext,nullvalue)
{
/*
 *--------------- GetResult(str) -----------------
 * GetResult(str)
 * 功能:通过XMLHTTP发送请求,返回结果.
 * 参数:str,字符串,发送条件.
 * 参数:sel,要构建的Select
 * 实例:GetResult(document.all.userid.value);
 * author:wanghr100(灰豆宝宝.net)
 * update:2004-5-27 19:02
 *--------------- GetResult(str) -----------------
 */
    var oBao = new ActiveXObject("Microsoft.XMLHTTP");
    oBao.open("GET","/"+webroot+"/getdictionarylist?"+str,false);
    oBao.send();
    //服务器端处理返回的是经过escape编码的字符串.
    //通过XMLHTTP返回数据,开始构建Select.

    var strRet = unescape(oBao.responseText);
    oBao = null;
    if(strRet.indexOf("(error)")!=-1){
      alert("下载字典表出错");
      return;
    }
    if(strRet.indexOf("(null)")!=-1){
      return;
    }

    BuildSel(strRet,sel,nullvaluetext,nullvalue);
}

function GetServerText(str)
{
    var oBao = new ActiveXObject("Microsoft.XMLHTTP");
    oBao.open("GET","/"+webroot+"/getdictionarylist?"+str,false);
    oBao.send();
    var strRet = unescape(oBao.responseText);
    return strRet;
}
function GetSubDictionary(dic_name,dic_code_prefix,dic_code_postfix,dic_code_midfix,conEx,sel){
  GetDicContent(dic_name,dic_code_prefix,dic_code_postfix,dic_code_midfix,conEx,sel,"---请选择---");
}

function GetDicContent(dic_name,dic_code_prefix,dic_code_postfix,dic_code_midfix,conEx,sel,nullvaluetext,nullvalue)
{
	var str = null;
        str = "dic_name="+dic_name;
        if(dic_code_prefix!=null){
          str = str + "&&dic_code_prefix="+dic_code_prefix;
        }
        if(dic_code_postfix!=null){
          str = str + "&&dic_code_postfix="+dic_code_postfix;
        }
        if(dic_code_midfix!=null){
          str = str + "&&dic_code_midfix="+dic_code_midfix;
        }
        if(conEx!=null){
          str = str + "&&conEx="+conEx;
        }
        GetDictionaryContent(str,sel,nullvaluetext,nullvalue);
}

function BuildSel(str,sel,nullvaluetext,nullvalue)
{
/*
 *--------------- BuildSel(str,sel) -----------------
 * BuildSel(str,sel)
 * 功能:通过str构建Select.
 * 参数:str,字符串,由服务端返回的.有特定结构"字符串1,字符串2,字符串3"
 * 参数:sel,要构建的Select
 * 实例:BuildSel(unescape(oBao.responseText),document.all.sel2)
 * author:wanghr100(灰豆宝宝.net)
 * update:2004-5-27 19:02
 *--------------- BuildSel(str,sel) -----------------
 */
    //先清空原来的数据.
    var selvalue = sel.value;
    sel.options.length=0;
    if(nullvaluetext!=null){
      if(typeof nullvalue=='undefined'||nullvalue==null){
      	nullvalue="";
      }
      sel.options[sel.options.length]=new Option(nullvaluetext,nullvalue);
    }

    var arrstr = new Array();
    var arrrow = new Array();
    arrstr = str.split(";;");
    //开始构建新的Select.
    for(var i=0;i<arrstr.length;i++)
    {
        arrrow = arrstr[i].split("::");
        if(arrrow.length==1){
           sel.options[sel.options.length]=new Option(arrrow[0],arrrow[0]);
        }else if(arrrow.length==2){
           sel.options[sel.options.length]=new Option(arrrow[1],arrrow[0]);
        }
    }
    if(sel.length!=0){
      sel.value = selvalue;
      if(sel.selectedIndex==-1){
        sel.selectedIndex=0;
      }
    }
}

function IDT18(strTemp){
  var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
  var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
  var nTemp = 0, i;

  if(strTemp.length!=15 && strTemp.length!=18){
    return strTemp;
  }

  if(strTemp.length==15){
    strTemp = strTemp.substr(0,6) + '19' + strTemp.substr(6,strTemp.length-6);
  }else{
    strTemp = strTemp.substr(0,17);
  }

  for(i = 0; i < strTemp.length; i ++){
    nTemp += strTemp.substr(i, 1) * arrInt[i];
  }

  strTemp += arrCh[nTemp % 11];

  return strTemp;
}

function ValidateIDNOWithMsg(strSfzhm,ignorenull){
  var iRet = ValidateIDNO(strSfzhm);
  switch(iRet){
    case 1:
    	if(!ignorenull){
         alert("身份证号码不能为空!");
    	}
        break;
    case 2:
    	alert("身份证号码长度必须为15位或18位");
        break;
    case 3:
    	alert("身份证号码必须为15位数字或18位数字(最后一位可以为X)!");
        break;
    case 4:
    	alert("身份证号码有误，正确的应为:"+IDT18(strSfzhm));
        break;
    default:
    	break;
  }
  return iRet;
}

function ValidateIDNO(strSfzhm){
/*  var patten = "^(\\d{15})|([0123456789X]{18})$";*/
  if(strSfzhm==null || strSfzhm.length==0){
    return 1;
  }
  if(strSfzhm.length!=15 && strSfzhm.length!=18){
    return 2;
  }

  var patten1 = "^\\d{15}$";
  var patten2 = "^\\d{17}[0123456789X]$";
  if(!Matchs(strSfzhm,patten1) && !Matchs(strSfzhm,patten2)){
    return 3;
  }

  if(strSfzhm.length==18){
    var strID18 = IDT18(strSfzhm);
    if(strID18!=strSfzhm){
      return 4;
    }
  }
  return 0;
}

function CorrectIDNO(strSfzhm,ignorenull){

  if(ValidateIDNO(strSfzhm,ignorenull)==0){
    return IDT18(strSfzhm);
  }

  return strSfzhm;
}

/*
将object转换为数组，如果object是数组则直接返回
*/
function asArray(object){
	var array;
	if(typeof object=='undefined'){
		return new Array();
	}else if(typeof object["length"]=='undefined'){
		//array = new Array(object);
		array=new Array();
		array[0]=object;
	}else{
		array = object;
	}
	
	return array;
}	

/*
	复制table标签的行
*/
function copyRows(
		desTab/*目的表格*/,
		srcTab/*源表格*/,
		from/*源起始位置*/,
		size/*复制行数*/,
		to/*目的表格位置*/
	){
	if(arguments.length<3)
		from=0;	
	
	if(arguments.length<4)
		size=srcTab.rows.length-from;
					
	if(arguments.length<5)
		to=-1;
		
	if(isNaN(from)||isNaN(size)||isNaN(to))
		return;
		
	if(size<=0)
		return;
	if(from>=srcTab.rows.length)
		return;
	if(to>=desTab.rows.length)
		to=desTab.rows.length;			
	if(to<0)
		to=desTab.rows.length;

	var toIndex=to;
	var newrow;
	for(var i=0;i<size;i++){
	  newrow = desTab.insertRow(toIndex++);
	  newrow.replaceNode(srcTab.rows(from+i).cloneNode(true));	  
	}
}
/*
	删除table标签从from开始的size行
*/
function deleteRows(table,from,size){
	if(table.rows.length==0)
		return;
		
	if(arguments.length<3)
		size=-1;	
	
	if(arguments.length<2)
		from=0;
	
	if(from>=table.rows.length)
		from=table.rows.length-1;
		
	if(size<0)
		size = table.rows.length-from;

	if(table.rows.length-from<size)
		size = table.rows.length-from;
	
	for(var i=size-1;i>=0;i--){
		table.deleteRow(from.parentNode.parentNode.rowIndex+i);
	}
}
/*
	删除table标签的index行，table至少应该有minrows行
*/
function deleteRow(table,index,minrows){
	if(arguments.length<3)
		minrows=0;
	if(arguments.length<2)
		index=-1;
	if(index==-1)
		index = table.rows.length-1;
	
	if(minrows<0)
		minrows=0;
	if(index<0)
		return;

	if(table.rows.length<=minrows)
		return;
	table.deleteRow(index);		
}

/*
	打开模式窗口
*/
function openModel(url,args,width,height,center,scroll,resizable,status){
	var features = '';
	if(arguments.length>2){
		features = features+'dialogWidth:'  + width + 'px;';
	}
	if(arguments.length>3){
		features = features+'dialogHeight:'  + height + 'px;';
	}
	if(arguments.length>4){
		if(center==false)
			features = features+'center:no';
	}
	if(arguments.length>5){
		if(scroll==false)
			features = features+'scroll:no';
	}
	if(arguments.length>6){
		if(resizable==false)
			features = features+'resizable:no';
	}				
	if(arguments.length>7){
		if(status==false)
			features = features+'status:no';
	}		
	return window.showModalDialog(url, args , features );		
}
/*
	打开模式工具栏
*/
function openModelToolBox(url,args,width,height){
	return openModel(url,args,width,height,true,false,false,false);
}

/*
	弹出普通窗口(使用window.open())，sFeatures应该不包括width和height属性
	建议url所定位的网页使用opener.setValue(value)方法来设置返回值
	另外，对应的opener应该存在setValue(value)的script函数
	
	参数说明：others:boolean数组，最多7位
	顺序分别位menu,toolbar,location,directories,scrollbars,status,resizeable
*/
function openNormal(url,target,top,left,width,height,others){
	var sFeatures = "";
	var otherFeatures = new Array("menu","toolbar","location","directories","scrollbars","status","resizeable");
	if(arguments.length>2&&top>0){
		sFeatures=sFeatures+'top='+top+",";
	}
	if(arguments.length>3&&left>0){
		sFeatures=sFeatures+'left='+left+",";
	}
	if(arguments.length>4&&width>0){
		sFeatures=sFeatures+'width='+width+",";
	}
	if(arguments.length>5&&height>0){
		sFeatures=sFeatures+'height='+height+",";
	}
	
	if(arguments.length>6){
		for(var i=0;i<Math.max(others.length,otherFeatures.length);i++){
			if(others[i]){
				sFeatures=sFeatures+otherFeatures[i]+'=yes,';
			}else{
				sFeatures=sFeatures+otherFeatures[i]+'=no,';
			}
		}
	}	
	
	if(sFeatures.length>0&&sFeatures.lastIndexOf(',')==sFeatures.length-1){
		sFeatures = sFeatures.substr(0,sFeatures.length-1);
	}
	
	return window.open(url,target,sFeatures);
}


function NormalWindow(url,target){
	if(arguments.length>0){
		this.url = url;
	}else{
		this.url='';
	}
	if(arguments.length>1){
		this.target = target;
	}else{
		this.target = '_blank';
	}
}

function features(){
	var sFeatures = "";
	if(typeof this.top!="undefined"&&this.top>0){
		sFeatures=sFeatures+'top='+this.top+"px,";
	}
	if(typeof this.left!="undefined"&&this.left>0){
		sFeatures=sFeatures+'left='+this.left+"px,";
	}	
	if(typeof this.width!="undefined"&&this.width>0){
		sFeatures=sFeatures+'width='+this.width+"px,";
	}
	if(typeof this.height!="undefined"&&this.height>0){
		sFeatures=sFeatures+'height='+this.height+"px,";
	}

	if(typeof this.menu!="undefined"){
		if(this.menu){
			sFeatures=sFeatures+'menubar=yes,';
		}else{
			sFeatures=sFeatures+'menubar=no,';
		}		
	}	
	if(typeof this.toolbar!="undefined"){
		if(this.toolbar){
			sFeatures=sFeatures+'toolbar=yes,';
		}else{
			sFeatures=sFeatures+'toolbar=no,';
		}		
	}	
	if(typeof this.location!="undefined"){
		if(this.location){
			sFeatures=sFeatures+'location=yes,';
		}else{
			sFeatures=sFeatures+'location=no,';
		}		
	}	
	if(typeof this.directories!="undefined"){
		if(this.directories){
			sFeatures=sFeatures+'directories=yes,';
		}else{
			sFeatures=sFeatures+'directories=no,';
		}		
	}	
	if(typeof this.scrollbars!="undefined"){
		if(this.scrollbars){
			sFeatures=sFeatures+'scrollbars=yes,';
		}else{
			sFeatures=sFeatures+'scrollbars=no,';
		}		
	}	
	
	if(typeof this.status!="undefined"){
		if(this.status){
			sFeatures=sFeatures+'status=yes,';
		}else{
			sFeatures=sFeatures+'status=no,';
		}		
	}
	if(typeof this.resizable!="undefined"){
		if(this.resizable){
			sFeatures=sFeatures+'resizable=yes,';
		}else{
			sFeatures=sFeatures+'resizable=no,';
		}		
	}
	
	if(sFeatures.length>0&&sFeatures.lastIndexOf(',')==sFeatures.length-1){
		sFeatures = sFeatures.substr(0,sFeatures.length-1);
	}
	return sFeatures;					
}
NormalWindow.prototype.features=features;

function openWindow(){
	var sFeatures = this.features();
	if(sFeatures.length!=0)
		return window.open(this.url,this.target,sFeatures);
	else
		return window.open(this.url,this.target);
}
NormalWindow.prototype.openWindow=openWindow;

function setArea(top,left,width,height){
	if(arguments.length>0){
		this.top = top;
	}
	if(arguments.length>1){
		this.left = left;
	}
	if(arguments.length>2){
		this.width = width;
	}
	if(arguments.length>3){
		this.height = height;
	}
	return this;	
}
NormalWindow.prototype.setArea=setArea;

function setFeature(name,value){	
	if(name=="top"){
		this.top=value;
	}else if(name=="left"){
		this.left=value;
	}else if(name=="width"){
		this.width=value;
	}else if(name=="height"){
		this.height=value;
	}else if(name=="menu"){
		this.menu=value;
	}else if(name=="toolbar"){
		this.toolbar=value;
	}else if(name=="location"){
		this.location=value;
	}else if(name=="directories"){
		this.directories=value;
	}else if(name=="scrollbars"){
		this.scrollbars=value;
	}else if(name=="status"){
		this.status=value;
	}else if(name=="resizeable"){
		this.resizeable=value;
	}
	return this;	
}
NormalWindow.prototype.setFeature=setFeature;


function openCenterWindow(url,width,height,target){
	var normalWindow = new NormalWindow();
	normalWindow.url = url;
	normalWindow.left = (screen.availWidth-width)/2;
	normalWindow.top = (screen.availHeight-height)/2;
	normalWindow.width = width;
	normalWindow.height = height;
	
	if(arguments.length>3){
		normalWindow.target = target;
	}
	
	var win= normalWindow.openWindow();
	win.focus();
	return win;
}



function openNormalCenterToolBox(url,width,height,locked){
	var normalToolBox = new NormalWindow();
	normalToolBox.url = url;
	normalToolBox.left = (screen.availWidth-width)/2;
	normalToolBox.top = (screen.availHeight-height)/2;
	normalToolBox.width = width;
	normalToolBox.height = height;	
	
	normalToolBox.menu=false;
	normalToolBox.toolbar=false;
	normalToolBox.location=false;
	normalToolBox.directories=false;
	normalToolBox.status=false;
	normalToolBox.scrollbars=true;	
	normalToolBox.resizable=true;		
	if(arguments.length>4&&locked){
		normalToolBox.scrollbars=false;	
		normalToolBox.resizable=false;		
	}
	return normalToolBox.openWindow();
}

function openNormalRelateToolBox(url,width,height,locked){
	var normalToolBox = new NormalWindow();
	normalToolBox.url = url;
	var src = event.srcElement;
	var elWidth = 0;
	var elHeight = 0;
	if(typeof src!="undefined"){
		elWidth = src.clientWidth;
		elHeight = src.clientHeight;
	}
	normalToolBox.left = event.screenX - event.offsetX+elWidth;	
	normalToolBox.top = event.screenY - event.offsetY;
	
	if(normalToolBox.left+width+30>screen.availWidth){
		normalToolBox.left =screen.availWidth-width-30;
		if(normalToolBox.left<0){
			normalToolBox.left = 0;
		}
	}	
	
	if(normalToolBox.top+height+50>screen.availHeight){
		normalToolBox.top = screen.availHeight-height-50;
		if(normalToolBox.top<0){
			normalToolBox.top = 0;
		}		
	}
	normalToolBox.width = width;
	normalToolBox.height = height;	
	
	normalToolBox.menu=false;
	normalToolBox.toolbar=false;
	normalToolBox.location=false;
	normalToolBox.directories=false;
	normalToolBox.status=false;
	normalToolBox.scrollbars=true;	
	normalToolBox.resizable=true;		
	if(arguments.length>4&&locked){
		normalToolBox.scrollbars=false;	
		normalToolBox.resizable=false;		
	}
	return normalToolBox.openWindow();
}

/*
	弹出普通工具栏(使用window.open())
*/
function openNormalToolBox(url,width,height,top,left,locked){
	var normalToolBox = new NormalWindow();
	normalToolBox.url = url;

	if(arguments.length>1){
		normalToolBox.width = width;
	}
	if(arguments.length>2){
		normalToolBox.height = height;
	}
	if(arguments.length>3){
		normalToolBox.top = top;
	}
	if(arguments.length>4){
		normalToolBox.left = left;
	}		
	
	normalToolBox.menu=false;
	normalToolBox.toolbar=false;
	normalToolBox.location=false;
	normalToolBox.directories=false;
	normalToolBox.status=false;
	normalToolBox.scrollbars=true;	
	normalToolBox.resizable=true;		
	if(arguments.length>4&&locked){
		normalToolBox.scrollbars=false;	
		normalToolBox.resizable=false;		
	}
	return normalToolBox.openWindow();
}

function newNormalToolWindow(url,width,height,top,left,locked){
	var normalToolBox = new NormalWindow();
	normalToolBox.url = url;
	if(arguments.length>1){
		normalToolBox.width = width;
	}
	if(arguments.length>2){
		normalToolBox.height = height;
	}
	if(arguments.length>3){
		normalToolBox.top = top;
	}
	if(arguments.length>4){
		normalToolBox.left = left;
	}	
	
	normalToolBox.menu=false;
	normalToolBox.toolbar=false;
	normalToolBox.location=false;
	normalToolBox.directories=false;
	normalToolBox.status=false;
	normalToolBox.scrollbars=true;	
	normalToolBox.resizable=true;		
	if(arguments.length>4&&locked){
		normalToolBox.scrollbars=false;	
		normalToolBox.resizable=false;		
	}
	return normalToolBox;	
}
//身份证校验15转18
function pub_certno15to18(i_citizen_id,i_century) {
	var citizen_id = new String(i_citizen_id);
	var century = new String(i_century);
	var new_citizen_id = new String();

	var tmp = new String();
	var id = new Array(18);
	var i = 1;

	//
	var w = new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2,1);

	if (citizen_id.length == 18)
		return citizen_id;
	else if (citizen_id.length!=15||century.length!=2)
		return -1;

	for(i=1;i<=15;i++) {
		tmp = citizen_id.charAt(i-1);
		if(tmp<"0"||tmp>"9")
			return -1;
		if(i<=6)
			id[i-1] = parseInt(tmp,10);
		else
			id[i+1] = parseInt(tmp,10);
	}

	for(i=7;i<=8;i++) {
		tmp = century.charAt(i-7);
		if(tmp<"0"||tmp>"9")
		return -1;
		id[i-1] = parseInt(tmp,10);
	}

	var count = 0;
	for(i=1;i<=17;i++) {
		count += id[i-1] * w[i-1];
	}
	id[17] = count - Math.floor(Math.floor(count/11)*11);
	id[17] = 12 - id[17];
	id[17] = id[17] - Math.floor(Math.floor(id[17]/11)*11);
	if(id[17] == 10)
		new_citizen_id = citizen_id.substr(0,6) + century + citizen_id.substr(6,9) + "X";
	else
		new_citizen_id = citizen_id.substr(0,6) + century + citizen_id.substr(6,9) + id[17];

	return new_citizen_id;
}
  //身份证校验
function checkSfzh(sfzh) {
if (sfzh==null || sfzh==""){
		return true;
		}
	else{
		if (sfzh.length == 18) {
			var pattern = /^([0-9]){6}(18|19|20)([0-9]){2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])([0-9]){3}([0-9]|x|X)$/;
				if(pattern.test(sfzh)) {
		 			 var id15 = sfzh.substr(0,6) + sfzh.substr(8,9);
		  						//alert(id15);
		  			if(sfzh!=pub_certno15to18(id15,"19")){

		    			return false;
		 			 }
		  				return true;
		}
		else {

			return false;
		}
	}
	else {

		return false;
	}
	}
  }
