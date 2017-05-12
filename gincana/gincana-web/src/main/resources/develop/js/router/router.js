/**
 * @author Marcelo Henrique
 */

/*
 *
 * @param {Object[]} routes - Array de rotas.
 * @param {string} routes.module - Modulo que deseja importar.
 * @param {string} routes.paths - Caminho correspondente a cada módulo.
 * @returns {undefined}
 */
function makeRoute(routes) {

    const {pathname} = window.location;

    for (let i = 0; i < routes.length; i++){
        const path = routes[i];
        const module = path.module;

        if(path.paths === pathname){
            require("../modules/"+module);
        }

        if (this.log){
            console.log("pathname:", pathname);
            console.log("paths:",path.paths);
            console.log("module:",module);
        }
    };
};

const Router = {
    log: false,
    makeRoute: makeRoute
};

Router.makeRoute.bind(Router);
export default Router;