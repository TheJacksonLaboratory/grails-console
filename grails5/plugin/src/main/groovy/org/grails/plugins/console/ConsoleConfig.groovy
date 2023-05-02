package org.grails.plugins.console

import grails.util.Environment

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

        if (config.getAt('enabled') instanceof Boolean) {
            enabled = config.getAt('enabled')
        } else {
            enabled = Environment.current == Environment.DEVELOPMENT
        }

        if (config.getAt('newFileText') instanceof String) {
            newFileText = config.getAt('newFileText')
        }

        if (config.getAt('indentWithTabs') instanceof Boolean) {
            indentWithTabs = config.getAt('indentWithTabs')
        }

        if (config.getAt('tabSize') instanceof Integer) {
            tabSize = config.getAt('tabSize')
        }

        if (config.getAt('indentUnit') instanceof Integer) {
            indentUnit = config.getAt('indentUnit')
        }

        if (config.getAt('fileStore.remote.defaultPath') instanceof String) {
            remoteFileStoreDefaultPath = config.getAt('fileStore.remote.defaultPath')
        }

        if (config.getAt('fileStore.remote.enabled') instanceof Boolean) {
            remoteFileStoreEnabled = config.getAt('fileStore.remote.enabled')
        }

        if (config.getAt('csrfProtection.enabled') instanceof Boolean) {
            csrfProtectionEnabled = config.getAt('csrfProtection.enabled')
        }

        if (config.getAt('baseUrl') instanceof List || config.getAt('baseUrl') instanceof String) {
            baseUrl = config.getAt('baseUrl')
        }
    }
}
