SUMMARY = "Simple Hello Custom app"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=33ef8b00d7f1a720a56a6d80ab7358a1"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "file://main.c \
           file://Makefile \
           file://LICENSE"

S = "${WORKDIR}"

do_compile() {
    oe_runmake CC="${CC}" CFLAGS="${CFLAGS}" LDFLAGS="${LDFLAGS}"
}

do_install() {
    oe_runmake install DESTDIR=${D}
}

# -------------------------------------------------------
# Copie le binaire compilé dans le dossier files/
# -------------------------------------------------------
do_copy_binary() {
    cp ${B}/hellocustom ${THISDIR}/files/
}
do_copy_binary[dirs] = "${WORKDIR}"
do_copy_binary[nostamp] = "1"
do_copy_binary[cleandirs] = ""
do_copy_binary[depends] = "hellocustom:do_compile"
addtask copy_binary after do_compile before do_install

FILES_${PN} = "/usr/bin/hellocustom"
