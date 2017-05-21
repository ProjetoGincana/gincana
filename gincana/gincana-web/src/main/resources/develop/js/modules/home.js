/**
 * @author Marcelo Henrique
 */

require("../../scss/home.scss");

const path = "membro/provas?prova=";
const opcoes = $(".conteudo-provas-tabela tbody tr");

opcoes.on("click", e => {
  const selected = $(e.currentTarget);
  const id = selected.children("th").text();
  window.location.href = path + id;
})