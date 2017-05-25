/**
 * @author Marcelo Henrique
 */
import Router from "./router/router"
require('../scss/general.scss');

const routes = [
    {
        module: "login",
        paths: "/login"
    },
    {
        module: "home",
        paths: "/"
    },
    {
      module: "provas",
      paths: "/comissao/provas"
    }
];

// Set true se deseja log
// Router.log = true;
Router.makeRoute(routes);
