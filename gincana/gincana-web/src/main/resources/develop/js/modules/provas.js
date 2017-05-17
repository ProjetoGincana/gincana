/**
  * @author eliseudaoritjr
*/

require('../../scss/provas.scss');

const opcoes = $(".conteudo-provas-tabela tr");
const campoEquipe = $(".conteudo-pontuar-form-prova");

opcoes.on("click", e => {
  const selected = $(e.currentTarget);
  const id = selected.children("th").text();

  opcoes.removeClass("selected");
  selected.addClass("selected");
  
  campoEquipe.attr("value", id);
})