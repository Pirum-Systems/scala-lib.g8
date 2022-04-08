{ pkgs ? import <nixpkgs> }:
  let
    jdk = pkgs.jdk11_headless;
    jre = pkgs.jre_minimal.override { inherit jdk; };
    sbt = pkgs.sbt.override { inherit jre; };
    coursier = pkgs.coursier.override { inherit jre; } ;
    scalafmt = pkgs.scalafmt.override { inherit jdk jre coursier; }; 
    scalafix = pkgs.scalafix.override { inherit jdk jre coursier; };
  in
    pkgs.mkShell {
      buildInputs = [
        jdk
        sbt
        scalafmt
        scalafix
        pkgs.awscli2
        pkgs.terraform
        pkgs.tflint 
      ];
    }