SUMMARY = "Mender public key package for rotation"
DESCRIPTION = "Provides the new Mender public key for artifact verification"
LICENSE = "CLOSED"
PR = "r0"

SRC_URI = "file://artifact-verify-key-rotation.pem"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/mender
    install -m 0644 ${WORKDIR}/artifact-verify-key-rotation.pem \
        ${D}${sysconfdir}/mender/artifact-verify-key-rotation.pem
}

FILES_${PN} = "${sysconfdir}/mender/artifact-verify-key-rotation.pem"
