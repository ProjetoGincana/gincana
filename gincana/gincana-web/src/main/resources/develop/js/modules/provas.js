/**
  * @author eliseudaoritjr
*/

require('../../scss/provas.scss');

const opcoes = $(".conteudo-provas-tabela tbody tr");
const campoEquipe = $(".conteudo-pontuar-form-prova");
const camposNota = $(".conteudo-pontuar-form-tabela-input");

opcoes.on("click", e => {
  const selected = $(e.currentTarget);
  const id = selected.children("th").text();
  const valorTotal = selected.children(".valor-total").text();

  opcoes.removeClass("selected");
  selected.addClass("selected");
  
  camposNota.attr("max", valorTotal);
  campoEquipe.attr("value", id);
})