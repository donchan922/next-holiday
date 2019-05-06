var holidayDate = new Date(document.getElementById("holidayDate").value);

function countdownTimer(){
  var nowDate = new Date();
  var period = holidayDate - nowDate;

  if (period >= 0) {
    var day = Math.floor(period / (1000 * 60 * 60 * 24));
    period -=  (day　*(1000 * 60 * 60 * 24));
    var hour = Math.floor(period / (1000 * 60 * 60));
    period -= (hour *(1000 * 60 * 60));
    var minutes =  Math.floor(period / (1000 * 60));
    period -= (minutes * (1000 * 60));
    var second = Math.floor(period / 1000);

    var insert = '<span class="message">あと、</span>';
    insert += '<span class="d">' + day +'日' + '</span>';
    insert += '<span class="h">' + hour + '時間'+'</span>';
    insert += '<span class="m">' + minutes +'分' + '</span>';
    insert += '<span class="s">' + second+ '秒'+ '</span>';

    document.getElementById('result').innerHTML = insert;
    setTimeout(countdownTimer,10);
  }
  else{
    var insert = '<span class="message">あと、</span>';
    insert += '<span class="d">' + '0日' + '</span>';
    insert += '<span class="h">' + '0時間' + '</span>';
    insert +=  '<span class="m">' + '0分' + '</span>';
    insert += '<span class="s">' + '0秒' + '</span>';

    document.getElementById('result').innerHTML = insert;
  }
}

countdownTimer();