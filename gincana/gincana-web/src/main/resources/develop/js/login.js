/**
  * @author Marcelo Henrique
*/

require('../scss/general.scss');
require('../scss/login.scss');
require('bootstrap-loader');

$(window).on('load', () => {

    $("form").on("submit", e => {

        const email = $("#email");
        const pass = $("#pass");

        if (email.val() === "" || pass.val() === ""){
            alert("Insira todos os campos"); //TODO inserir mensagem em caixa de alerta.
            e.preventDefault();
        }
    });
});