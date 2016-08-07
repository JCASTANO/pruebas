function sumar() {
  var numero1 = Number(document.getElementById("numero1").value);
  var numero2 = Number(document.getElementById("numero2").value);
  var resultado = document.getElementById("resultado");
  resultado.innerHTML = numero1 + numero2;
}
