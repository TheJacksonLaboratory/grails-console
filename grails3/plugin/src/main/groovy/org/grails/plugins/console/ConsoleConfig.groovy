package org.grails.plugins.console

import grails.util.Environment
import org.grails.config.PropertySourcesConfig

class ConsoleConfig {

    boolean enabled
    String newFileText = null
    boolean indentWithTabs = false
    int tabSize = 4
    int indentUnit = 4
    String remoteFileStoreDefaultPath = null
    boolean remoteFileStoreEnabled = true
    boolean csrfProtectionEnabled = true
    def baseUrl

    ConsoleConfig(Map config) {
        PropertySourcesConfig srcConfig = config

        if (srcConfig.navigate('enabled') instanceof Boolean) {
            enabled = srcConfig.navigate('enabled')
        } else {
            enabled = Environment.current == Environment.DEVELOPMENT
        }

        if (srcConfig.navigate('newFileText') instanceof String) {
            newFileText = srcConfig.navigate('newFileText')
        }

        if (srcConfig.navigate('indentWithTabs') instanceof Boolean) {
            indentWithTabs = srcConfig.navigate('indentWithTabs')
        }

        if (srcConfig.navigate('tabSize') instanceof Integer) {
            tabSize = srcConfig.navigate('tabSize')
        }

        if (srcConfig.navigate('indentUnit') instanceof Integer) {
            indentUnit = srcConfig.navigate('indentUnit')
        }

        if (srcConfig.navigate('fileStore.remote.defaultPath') instanceof String) {
            remoteFileStoreDefaultPath = srcConfig.navigate('fileStore.remote.defaultPath')
        }

        if (srcConfig.navigate('fileStore.remote.enabled') instanceof Boolean) {
            remoteFileStoreEnabled = srcConfig.navigate('fileStore.remote.enabled')
        }

        if (srcConfig.navigate('csrfProtection.enabled') instanceof Boolean) {
            csrfProtectionEnabled = srcConfig.navigate('csrfProtection.enabled')
        }

        if (srcConfig.navigate('baseUrl') instanceof List || srcConfig.navigate('baseUrl') instanceof String) {
            baseUrl = srcConfig.navigate('baseUrl')
        }
    }
}
