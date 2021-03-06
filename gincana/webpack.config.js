/**
 * @author Marcelo Henrique
 */
const webpack = require('webpack');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const {join} = require('path');

module.exports = {
    entry: {
        "main": "./gincana-web/src/main/resources/develop/js/index.js"
    },
    output: {
        path: join(__dirname, "./gincana-web/src/main/resources/static"),
        filename:  "js/[name]-bundle.js",
        publicPath: 'gincana-web/src/main/resources/static'
    },
    devServer: {
        port: 3000
    },
    resolve: {
        extensions: ['.js', '.jsx']
    },
    module: {
        rules: [
            {
                test: /\.jsx?$/,
                exclude: /node_modules/,
                loaders: ["babel-loader"]
            },
            {
                test: /.scss$/,
                use: ExtractTextPlugin.extract({
                    fallback: 'style-loader',
                    use: ['css-loader', 'sass-loader']
                })
            },
            { test: /\.(png|woff|woff2|eot|ttf|svg)$/, loader: 'url-loader?limit=100000&name=css/fonts/[hash].[ext]' }
        ]
    },
    plugins: [
        new webpack.ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery'
        }),
        new ExtractTextPlugin({
            filename: 'css/[name]-bundle.css',
            allChunks: true
        }),
    ]
};