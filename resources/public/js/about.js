(function() {
  var yee = '<img src="https://i.imgur.com/ENRir8s.png"></img>';
  var main = document.getElementById('main');
  setInterval( function() {
    main.innerHTML += new Array(50).join(yee);
  }, 500);
})();
