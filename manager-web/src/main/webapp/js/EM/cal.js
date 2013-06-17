/*
webroot用来指定web根目录
*/
var webroot="manager-web";
function fPopUpCalendarDlg(inputid,startYear,endYear)
{
	var pattern = /^(19|20)([0-9]){2}$/;
	flag=pattern.test(startYear);
	if(!flag)startYear=1900;
	flag=pattern.test(endYear);
	if(!flag)endYear=2050;

	var currentDate = inputid.value;

	var arguments = new Array(startYear,endYear,0,0,0)

	var pattern = /^(19|20)([0-9]){2}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
	flag=pattern.test(currentDate);
	if(flag)
	{
		iYear=currentDate.substring(0,4);
		iMonth=currentDate.substring(5,7);
		iDay=currentDate.substring(8,10);
		arguments = new Array(startYear,endYear,iYear,iMonth,iDay)
	}


	showx = event.screenX - event.offsetX + 18;
	showy = event.screenY - event.offsetY - 210;

	var features =
		'dialogWidth:'  + 200 + 'px;' +
		'dialogHeight:' + 270 + 'px;' +
		'dialogLeft:'   + showx     + 'px;' +
		'dialogTop:'    + showy     + 'px;' +
		'status:off;scroll:off;resizable:off';
	//var root = "manager-web";
	//if(root.length!=0){
	//	root = "/"+root;
	//}
	
	retval = window.showModalDialog("calendar.htm", arguments , features );

	var calctrl = eval(inputid)
	if( retval != null ){
		calctrl.value = retval;
	}else{
		//alert("canceled");
	}
}

function fPopUpDlg(inputid,purl,w,h)
{
  	var trueurl;

        trueurl=purl;

        if(purl.charAt(0)=='/'){
          trueurl = '/'+webroot+purl;
        }


  	if(w==0){
            w=screen.availWidth-100;
  	}
  	if(h==0){
            h=screen.availHeight-100;
  	}

	showx = (screen.availWidth-w)/2
	showy = (screen.availHeight-h)/2

	var features =
		'dialogWidth:'  + w + 'px;' +
		'dialogHeight:' + h + 'px;' +
		'dialogLeft:'   + showx     + 'px;' +
		'dialogTop:'    + showy     + 'px;' +
		'directories:no; localtion:no; menubar:no; status=no; toolbar=no;scrollbars:yes;Resizeable=no';

	retval = window.showModalDialog(trueurl, null , features );
	var calctrl = eval(inputid)
	if( retval != null ){
		calctrl.value = retval;
	}else{
		//alert("canceled");
	}
}

