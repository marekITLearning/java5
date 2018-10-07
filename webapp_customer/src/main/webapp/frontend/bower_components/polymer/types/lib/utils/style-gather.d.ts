/**
 * DO NOT EDIT
 *
 * This file was automatically generated by
 *   https://github.com/Polymer/gen-typescript-declarations
 *
 * To modify these typings, edit the source file(s):
 *   lib/utils/style-gather.html
 */

/// <reference path="resolve-url.d.ts" />

declare namespace Polymer {

  /**
   * Module with utilities for collection CSS text from `<templates>`, external
   * stylesheets, and `dom-module`s.
   */
  namespace StyleGather {


    /**
     * Returns a list of <style> elements in a space-separated list of `dom-module`s.
     *
     * @returns Array of contained <style> elements
     */
    function stylesFromModules(moduleIds: string): HTMLStyleElement[];


    /**
     * Returns a list of <style> elements in a given `dom-module`.
     * Styles in a `dom-module` can come either from `<style>`s within the
     * first `<template>`, or else from one or more
     * `<link rel="import" type="css">` links outside the template.
     *
     * @returns Array of contained styles.
     */
    function stylesFromModule(moduleId: string): HTMLStyleElement[];


    /**
     * Returns the `<style>` elements within a given template.
     *
     * @returns Array of styles
     */
    function stylesFromTemplate(template: HTMLTemplateElement, baseURI: string): HTMLStyleElement[];


    /**
     * Returns a list of <style> elements  from stylesheets loaded via `<link rel="import" type="css">` links within the specified `dom-module`.
     *
     * @returns Array of contained styles.
     */
    function stylesFromModuleImports(moduleId: string): HTMLStyleElement[];


    /**
     * @returns Array of contained styles
     */
    function _stylesFromModuleImports(module: HTMLElement): HTMLStyleElement[];


    /**
     * Returns CSS text of styles in a space-separated list of `dom-module`s.
     * Note: This method is deprecated, use `stylesFromModules` instead.
     *
     * @returns Concatenated CSS content from specified `dom-module`s
     */
    function cssFromModules(moduleIds: string): string;


    /**
     * Returns CSS text of styles in a given `dom-module`.  CSS in a `dom-module`
     * can come either from `<style>`s within the first `<template>`, or else
     * from one or more `<link rel="import" type="css">` links outside the
     * template.
     *
     * Any `<styles>` processed are removed from their original location.
     * Note: This method is deprecated, use `styleFromModule` instead.
     *
     * @returns Concatenated CSS content from specified `dom-module`
     */
    function cssFromModule(moduleId: string): string;


    /**
     * Returns CSS text of `<styles>` within a given template.
     *
     * Any `<styles>` processed are removed from their original location.
     * Note: This method is deprecated, use `styleFromTemplate` instead.
     *
     * @returns Concatenated CSS content from specified template
     */
    function cssFromTemplate(template: HTMLTemplateElement, baseURI: string): string;


    /**
     * Returns CSS text from stylesheets loaded via `<link rel="import" type="css">`
     * links within the specified `dom-module`.
     *
     * Note: This method is deprecated, use `stylesFromModuleImports` instead.
     *
     * @returns Concatenated CSS content from links in specified `dom-module`
     */
    function cssFromModuleImports(moduleId: string): string;


    /**
     * @returns Concatenated CSS content from links in the dom-module
     */
    function _cssFromModuleImports(module: HTMLElement): string;
  }
}
