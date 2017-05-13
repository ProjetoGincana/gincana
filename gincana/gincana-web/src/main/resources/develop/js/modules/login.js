/**
  * @author Marcelo Henrique
*/

require('../../scss/login.scss');

$(window).on('load', () => {

    $("form").on("submit", e => {

        const email = $("input.email");
        const pass = $("input.senha");

        if (email.val() === "" || pass.val() === ""){
            alert("Insira todos os campos"); //TODO inserir mensagem em caixa de alerta.
            e.preventDefault();
        }
    });
});