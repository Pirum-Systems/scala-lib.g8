{
  description = "Development environment for working in $name$";

  inputs.flake-utils.url = github:numtide/flake-utils;

  outputs = { self, nixpkgs, flake-utils }:
    flake-utils.lib.simpleFlake {
      inherit self nixpkgs;

      name = "$name$";

      shell = ./shell.nix;
    };
}