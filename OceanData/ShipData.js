//선박운항정보 api 
const express = require('express')();
const server = require('http').createServer(express);
const io = require('socket.io')(server);
const xml = require('xml-js');
const request = require('request'); //요청하기 위해 선언

//var db_config = require('./DBconfig/database.js'); //db정보 연결
//var conn = db_config.init(); //DB 연결객체 반환

//db_config.connect(conn); 

/*
io.on('connection', (socket) => {

    socket.on('PutShipData',(data)=>{
        console.log(data);
    });

    var prtAgCdData;
    var sdeData;
    var edeData;
    var clsgnData;

});
server.listen(3000);
*/



var serviceKey = '=NYQp85bV4GjxauduBdSwaoZb3uT9jcgbECXr1WNuzKbPSx5%2Fdv7m%2B5gV6xRZk3yYt5M4dzOuspvMzSwrPgtd7g%3D%3D';

var url = 'http://apis.data.go.kr/1192000/VsslEtrynd2/Info'; //연결할 url
var queryParams = '?' + encodeURIComponent('serviceKey') + serviceKey; //인증키
queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1');
queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); 
queryParams += '&' + encodeURIComponent('prtAgCd') + '=' + encodeURIComponent('020');
queryParams += '&' + encodeURIComponent('sde') + '=' + encodeURIComponent('20170209'); 
queryParams += '&' + encodeURIComponent('ede') + '=' + encodeURIComponent('20170209'); 
queryParams += '&' + encodeURIComponent('clsgn') + '=' + encodeURIComponent('9VHZ8'); 



request.get(url + queryParams, (error,response,body)=>{
    if(error){
        console.log(error);
    }
    else{

        if(response.statusCode == 200){
            var result = body;         
            var xmlToJson = xml.xml2json(result, {compact: true, spaces: 4});  
            console.log(xmlToJson+"\n");
            
            
            //아이템 사항
            const prtCdData = JSON.parse(xmlToJson).response.body.items.item.prtAgCd._text;
            const prtNmData = JSON.parse(xmlToJson).response.body.items.item.prtAgNm._text;
            const Cls = JSON.parse(xmlToJson).response.body.items.item.clsgn._text;
            const VsslNm = JSON.parse(xmlToJson).response.body.items.item.vsslNm._text;
            const VsslNltyNm = JSON.parse(xmlToJson).response.body.items.item.vsslNltyNm._text;
            const VsslKndNm = JSON.parse(xmlToJson).response.body.items.item.vsslKndNm._text;
            const EtryptPurpsNm = JSON.parse(xmlToJson).response.body.items.item.etryptPurpsNm._text;
            const DstnPrtNm = JSON.parse(xmlToJson).response.body.items.item.dstnPrtNm._text;


            //세부 사항
            const EtryptDt = JSON.parse(xmlToJson).response.body.items.item.details.detail[0].etryptDt._text;
            const TkoffDt = JSON.parse(xmlToJson).response.body.items.item.details.detail[1].tkoffDt._text;
            const EtryndNm = JSON.parse(xmlToJson).response.body.items.item.details.detail[0].etryndNm._text;
            const IbobprtNm = JSON.parse(xmlToJson).response.body.items.item.details.detail[0].ibobprtNm._text;
            const LaidupFcltyNm = JSON.parse(xmlToJson).response.body.items.item.details.detail[0].laidupFcltyNm._text;

            console.log(prtCdData);
            console.log(prtNmData);
            console.log(Cls);
            console.log(VsslNm);
            console.log(VsslNltyNm);
            console.log(VsslKndNm);
            console.log(EtryptPurpsNm);
            console.log(DstnPrtNm);

            console.log(EtryptDt);
            console.log(TkoffDt);
            console.log(EtryndNm);
            console.log(IbobprtNm);
            console.log(LaidupFcltyNm);
        }
    }

});


   


