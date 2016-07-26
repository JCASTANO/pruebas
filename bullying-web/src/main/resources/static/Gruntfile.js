module.exports = function(grunt) {

  grunt.initConfig({
    concat: {
      js: {
        src: [
            'app/bower_components/jquery/dist/jquery.min.js',
            'app/bower_components/bootstrap/dist/js/bootstrap.min.js',
            'app/bower_components/angular/angular.js',
            'app/bower_components/angular-route/angular-route.js',
            'app/bower_components/angular-resource/angular-resource.js',
            'app/bower_components/angular-bootstrap/ui-bootstrap-tpls.min.js',
            'app/bower_components/angular-ui-notification/dist/angular-ui-notification.min.js',
            'app/bower_components/angular-ui-router/release/angular-ui-router.min.js',
            'app/scripts/*.js',
            'app/scripts/**/*.js'
            ],
        dest: 'app/dist/bullying.js'
      }
    },
    uglify: {
      options: {
        mangle: false
      },
      my_target: {
        files: {
          'app/dist/bullying.min.js': ['app/dist/bullying.js']
        }
      }
    },
    cssmin: {
      options: {
        shorthandCompacting: false,
        roundingPrecision: -1
      },
      target: {
        files: {
          'app/dist/bullying.min.css': [
            'app/bower_components/bootstrap/dist/css/bootstrap.min.css',
            'app/bower_components/angular-ui-notification/dist/angular-ui-notification.min.css'
          ]
        }
      }
    }
  });

  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-ng-annotate');
  grunt.loadNpmTasks('grunt-contrib-cssmin');

  grunt.registerTask('dist', ['concat' , 'uglify', 'cssmin']);
};
