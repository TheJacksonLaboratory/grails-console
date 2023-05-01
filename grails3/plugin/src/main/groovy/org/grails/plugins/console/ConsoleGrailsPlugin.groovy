package org.grails.plugins.console

import grails.config.Config
import grails.plugins.*
import org.grails.config.NavigableMapConfig
import org.grails.config.PropertySourcesConfig

class ConsoleGrailsPlugin extends Plugin {

   // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.0.0 > *"

    String title = 'Console Plugin'
    String description = 'A web-based Groovy console for interactive runtime application management and debugging'
    String documentation = 'https://github.com/sheehan/grails-console/blob/master/README.md'

    String license = 'APACHE'
    def developers = [
        [name: 'Siegfried Puchbauer', email: 'siegfried.puchbauer@gmail.com'],
        [name: 'Mingfai Ma', email: 'mingfai.ma@gmail.com'],
        [name: 'Burt Beckwith', email: 'burt@burtbeckwith.com'],
        [name: 'Matt Sheehan', email: 'mr.sheehan@gmail.com']
    ]
    def issueManagement = [system: 'github', url: 'https://github.com/sheehan/grails-console/issues']
    def scm = [url: 'https://github.com/sheehan/grails-console']

    void doWithApplicationContext() {
        config.merge(['grails':['assets':['plugin':['console': ['excludes': ['**/*']]]]]])

        ConsoleUtil.initJsonConfig()
    }

    Closure doWithSpring() {{->
        Config blankConfig = new PropertySourcesConfig()
        consoleConfig(ConsoleConfig, config.getProperty('grails.plugin.console', NavigableMap, blankConfig))
    }}
}
