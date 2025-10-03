SUMMARY = "Simple Hello Custom app"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=33ef8b00d7f1a720a56a6d80ab7358a1"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "file://main.c"

S = "${WORKDIR}"

do_compile() {
    oe_runmake CC="${CC}" CFLAGS="${CFLAGS}" LDFLAGS="${LDFLAGS}"
}

do_install() {
    oe_runmake install DESTDIR=${D}
}

FILES_${PN} = "/usr/bin/hellocustom"
