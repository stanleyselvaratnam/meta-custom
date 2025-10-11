SUMMARY = "Mender public key package"
DESCRIPTION = "Installs the main Mender public key (.pem) for artifact verification"
LICENSE = "CLOSED"
PR = "r1"

SRC_URI = "file://public.key"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/mender
    # Conversion de .key → .pem pour le client Mender
    openssl rsa -in ${WORKDIR}/public.key -pubin -outform PEM \
        -out ${D}${sysconfdir}/mender/artifact-verify-key.pem
}

FILES_${PN} = "${sysconfdir}/mender/artifact-verify-key.pem"
