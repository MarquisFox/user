"use strict";

const {src, dest} = require("gulp");
const gulp = require("gulp");
const autoprefixer = require('gulp-autoprefixer');
const rename = require("gulp-rename");
const sass = require("gulp-sass")(require("sass"));
const cleanCSS = require('gulp-clean-css');
var sourcemaps = require('gulp-sourcemaps');
const uglify = require("gulp-uglify");
const plumber = require("gulp-plumber");
const imagemin = require('gulp-imagemin');
const del = require("del");
const notify = require("gulp-notify");
// const webpack = require('webpack');
const webpackStream = require('webpack-stream');
const browserSync = require("browser-sync").create();
const spawn = require('child_process').spawn;

/* Paths */
const srcPath = 'src/main/resources/static/';
const distPath = 'target/classes/';
const htmlPath = 'src/main/resources/templates/**/';

const path = {
    build: {
        html:   distPath + "templates/",
        js:     distPath + "js/",
        css:    distPath + "css/",
        images: distPath + "images/",
        fonts:  distPath + "fonts/"
    },
    src: {
        html:   htmlPath + "*.html",
        js:     srcPath + "js/*.js",
        css:    srcPath + "scss/*.scss",
        images: srcPath + "images/**/*.{jpg,png,svg,gif,ico,webp,webmanifest,xml,json}",
        fonts:  [srcPath + "fonts/**/*.{otf,eot,woff,woff2,ttf,svg}"]
    },
    watch: {
        html:   htmlPath + "**/*.html",
        js:     srcPath + "js/**/*.js",
        css:    srcPath + "scss/**/*.scss",
        images: srcPath + "images/**/*.{jpg,png,svg,gif,ico,webp,webmanifest,xml,json}",
        fonts:  srcPath + "fonts/**/*.{otf,eot,woff,woff2,ttf,svg}"
    },
    clean: "./" + distPath
}


/* Tasks */

function serve() {
    browserSync.init({
        open: false,
        // server: {
        //     baseDir: "./" + distPath
        // },
        proxy: {
            target: "127.0.0.1:8080"
        },
        reloadDelay: 100,
        reloadDebounce: 200,
        notify: false,
        injectChanges: false,
        ghostMode: false,
    });
}

function html(cb) {
    // panini.refresh();
    return src([path.src.html])
        .pipe(plumber())
        // .pipe(dest(path.build.html))
        .pipe(browserSync.reload({stream: true}));

    cb();
}

function css(cb) {
    return src(path.src.css, {base: srcPath + "scss/"})
        .pipe(plumber({
            errorHandler : function(err) {
                notify.onError({
                    title:    "SCSS Error",
                    message:  "Error: <%= error.message %>"
                })(err);
                this.emit('end');
            }
        }))
        .pipe(sourcemaps.init())
        .pipe(sass({
            includePaths: './node_modules/'
        }))
        .pipe(autoprefixer({
            cascade: true
        }))
        .pipe(cleanCSS({level: {1: {specialComments: 0}}}))
        .pipe(sourcemaps.write('.'))
        .pipe(dest(path.build.css))
        .pipe(rename({
            suffix: ".min",
            extname: ".css"
        }))
        .pipe(dest(path.build.css))
        .pipe(browserSync.reload({stream: true}));

    cb();
}

function cssWatch(cb) {
    return src(path.src.css, {base: srcPath + "scss/"})
        .pipe(plumber({
            errorHandler : function(err) {
                notify.onError({
                    title:    "SCSS Error",
                    message:  "Error: <%= error.message %>"
                })(err);
                this.emit('end');
            }
        }))
        .pipe(sourcemaps.init())
        .pipe(sass({
            includePaths: './node_modules/'
        }))
        .pipe(rename({
            suffix: ".min",
            extname: ".css"
        }))
        .pipe(sourcemaps.write('.'))
        .pipe(dest(path.build.css))
        .pipe(browserSync.reload({stream: true}));

    cb();
}

function js(cb) {
    return src(path.src.js, {base: srcPath + 'js/'})
        .pipe(plumber({
            errorHandler : function(err) {
                notify.onError({
                    title:    "JS Error",
                    message:  "Error: <%= error.message %>"
                })(err);
                this.emit('end');
            }
        }))
        .pipe(webpackStream({
          mode: "production",
          output: {
            filename: 'app.js',
          },
          plugins: [
            // new webpack.ProvidePlugin({
            //   $: 'jquery',
            //   jQuery: 'jquery',
            //   'window.jQuery': 'jquery'
            // }),
          ], 
          module: {
            rules: [
              {
                test: /\.(js)$/,
                exclude: /(node_modules)/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }
              }
            ]
          }
        }))
        .pipe(dest(path.build.js))
        .pipe(browserSync.reload({stream: true}));

    cb();
}

function jsWatch(cb) {
    return src(path.src.js, {base: srcPath + 'js/'})
        .pipe(plumber({
            errorHandler : function(err) {
                notify.onError({
                    title:    "JS Error",
                    message:  "Error: <%= error.message %>"
                })(err);
                this.emit('end');
            }
        }))
        .pipe(webpackStream({
          mode: "development",
          output: {
            filename: 'app.js',
          },
          plugins: [
            // new webpack.ProvidePlugin({
            //   $: 'jquery',
            //   jQuery: 'jquery',
            //   'window.jQuery': 'jquery'
            // }),
          ]
        }))
        .pipe(dest(path.build.js))
        .pipe(browserSync.reload({stream: true}));

    cb();
}

function images(cb) {
    return src(path.src.images)
        .pipe(imagemin([
            imagemin.gifsicle({interlaced: true}),
            imagemin.mozjpeg({quality: 95, progressive: true}),
            imagemin.optipng({optimizationLevel: 5}),
            imagemin.svgo({
                plugins: [
                    { removeViewBox: true },
                    { cleanupIDs: false }
                ]
            })
        ],
        // {verbose: true}
        ))
        .pipe(dest(path.build.images))
        .pipe(browserSync.reload({stream: true}));

    cb();
}

function fonts(cb) {
    return src(path.src.fonts)
        .pipe(dest(path.build.fonts))
        .pipe(browserSync.reload({stream: true}));

    cb();
}

//function clean(cb) {
//    return del(path.clean);
//
//    cb();
//}

function watchFiles() {
    gulp.watch([path.watch.html], html);
    gulp.watch([path.watch.css], cssWatch);
    gulp.watch([path.watch.js], jsWatch);
    gulp.watch([path.watch.images], images);
    gulp.watch([path.watch.fonts], fonts);
}



//const build = gulp.series(clean, gulp.parallel(html, css, js, images, fonts), django);
const build = gulp.parallel(html, css, js, images, fonts));
const watch = gulp.parallel(build, watchFiles, serve);


/* Exports Tasks */
exports.html = html;
exports.css = css;
exports.js = js;
exports.images = images;
exports.fonts = fonts;
exports.clean = clean;
exports.build = build;
exports.watch = watch;
exports.default = watch;
