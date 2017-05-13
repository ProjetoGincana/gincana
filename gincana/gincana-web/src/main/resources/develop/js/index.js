/**
 * @author Marcelo Henrique
 */
import Router from "./router/router"

const routes = [
    {
        module: "login",
        paths: "/login"
    },
    {
        module: "home",
        paths: "/"
    }
];

// Set true se deseja log
// Router.log = true;
Router.makeRoute(routes);